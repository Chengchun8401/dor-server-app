package com.city.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.app.dao.entity.Record;
import com.city.app.dao.mapper.DormitoryMapper;
import com.city.app.dao.mapper.RecordMapper;
import com.city.app.service.IRecordService;
import com.city.app.common.param.UserClockInParam;
import com.city.app.common.vo.Result;
import com.city.app.utils.FaceAipUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @version v1.0
 * @ClassName: RecordServiceImpl
 * @Description: 用户打卡业务接口 错误码 12001 - 12999
 * @Author: CitySpring
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private FaceAipUtils faceAipUtils;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result getUserClockInfo(String token) {
        String userId = stringRedisTemplate.opsForValue().get("TOKEN_" + token);
        if(Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        Record record = recordMapper.getUserClockInfo(Long.parseLong(userId));

        // 本日没有打卡记录
        if(record == null){
            Record re = new Record();
            re.setUserId(userId);
            re.setTime(LocalDateTime.now());
            re.setTypeId(0);// 0未打卡 1打卡成功 2打卡失败

            if(recordMapper.insert(re) > 0){
                return Result.success(null, re);
            }
            return Result.fail("打卡状态查询失败", 12001);
        }

        return Result.success(null, record);
    }

    @Override
    public Result userClockIn(UserClockInParam param, String token) {
        String userId = stringRedisTemplate.opsForValue().get("TOKEN_" + token);
        if(Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        String[] row = param.getFace().split(",");
        String res = faceAipUtils.faceSearch(row[1]);
        if(Strings.isBlank(res)){
            return Result.fail("打卡失败：人脸认证失败", null);
        }

        String building = dormitoryMapper.getBuildingByUserId(Long.parseLong(userId));
        if(!param.getAddress().contains(building)){
            return Result.fail("未在学生公寓，打卡失败", 12001);
        }

        Record record = recordMapper.getUserClockInfo(Long.parseLong(userId));
        if(record == null){
            return Result.fail("打卡信息异常，请稍后再试", 12002);
        }

        record.setAddress(param.getAddress());
        record.setTime(LocalDateTime.now());
        record.setTypeId(1);

        if(recordMapper.updateById(record) > 0){
            return Result.success("打卡成功", record);
        }

        return Result.fail("打卡失败，请重新尝试", 12003);
    }
}
