package com.city.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.app.common.param.UserBindParam;
import com.city.app.common.param.UserFaceParam;
import com.city.app.common.vo.UserVo;
import com.city.app.dao.entity.Dormitory;
import com.city.app.dao.entity.Major;
import com.city.app.dao.entity.Room;
import com.city.app.dao.entity.User;
import com.city.app.dao.mapper.DormitoryMapper;
import com.city.app.dao.mapper.UserMapper;
import com.city.app.service.IUserLoginService;
import com.city.app.utils.FaceAipUtils;
import com.city.app.utils.TokenService;
import com.city.app.common.param.UserLoginParam;
import com.city.app.common.param.UserRegistryParam;
import com.city.app.common.vo.Result;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: UserServiceImpl
 * @Description: 用户登录注册业务模块 错误码 10001 - 10999
 * @Author: CitySpring
 */

@Service
public class UserLoginServiceImpl extends ServiceImpl<UserMapper, User> implements IUserLoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenService tokenService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private FaceAipUtils faceAipUtils;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public Result userLogin(UserLoginParam param) {
        User user = userMapper.loginByUserId(Long.parseLong(param.getUsername()));
        if(user == null){
            return Result.fail("用户不存在", 10001);
        }

        if(!user.getPassword().equals(param.getPassword())){
            return Result.fail("登录密码错误", 10002);
        }

        String token = tokenService.createToken(user.getId().toString());
        return Result.success("欢迎访问", token);
    }

    @Override
    @Transactional
    public Result userRegistry(UserRegistryParam param) {
        String[] faceData = param.getFace().split(",");
        Boolean row = faceAipUtils.faceRegister(param.getId(), faceData[1]);
        if(!row){
            return Result.fail("注册失败", 10004);
        }

        User user = new User();
        user.setId(Long.parseLong(param.getId()));
        user.setPassword(param.getPassword());
        user.setName(param.getName());
        user.setMajorId(param.getMajorId());

        int insert = userMapper.insert(user);
        if(insert <= 0){
            faceAipUtils.faceDelete(param.getId()); // 删除人脸库信息
            return Result.fail("注册失败", 10003);
        }

        String token = tokenService.createToken(param.getId());
        return Result.success("注册成功", token);
    }

    @Override
    public Result userLogout(String token) {
        stringRedisTemplate.delete("TOKEN_" + token);
        return Result.success("注销成功", null);
    }

    @Override
    public Result userLoginByFace(UserFaceParam param) {
        String[] faceData = param.getFace().split(",");

        String userId = faceAipUtils.faceSearch(faceData[1]);
        if(userId == null){
            return Result.fail("人脸校验失败，请稍后再试", 10006);
        }

        String token = tokenService.createToken(userId);
        return Result.success("欢迎访问", token);
    }

    @Override
    public Result getUserInfo(String token) {
        String userId = stringRedisTemplate.opsForValue().get("TOKEN_" + token);
        if (Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        UserVo userInfo = userMapper.getUserInfo(Long.parseLong(userId));
        if(userInfo == null){
            return Result.fail("用户信息获取失败", 10007);
        }

        return Result.success(null, userInfo);
    }

    @Override
    public Result getMajorInfo() {
        List<Major> majorInfo = userMapper.getMajorInfo();
        if(majorInfo.isEmpty()){
            return Result.fail("专业信息获取失败", 10008);
        }

        return Result.success(null, majorInfo);
    }

    @Override
    public Result bindDorInfo(UserBindParam param, String token) {
        String userId = stringRedisTemplate.opsForValue().get("TOKEN_" + token);

        Long dormitoryInfo = dormitoryMapper.getDormitoryInfo(Long.parseLong(param.getBuildingId()), Long.parseLong(param.getRoomId()));
        if(dormitoryInfo == null){
            return Result.fail("寝室信息获取失败，请稍后再试", 10009);
        }

        User user = userMapper.selectById(userId);
        if(user == null){
            return Result.fail("用户获取失败，请稍后再试", 10010);
        }

        user.setDormitoryId(dormitoryInfo);
        if(param.getSex() != null){
            user.setSex(param.getSex());
        }

        if(userMapper.updateById(user) > 0){
            return Result.success("寝室信息绑定成功", null);
        }

        return Result.fail("寝室信息绑定失败，请稍后再试", 10012);
    }

}
