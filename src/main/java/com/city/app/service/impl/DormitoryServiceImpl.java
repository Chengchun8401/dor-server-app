package com.city.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.app.common.param.PayParam;
import com.city.app.common.vo.*;
import com.city.app.dao.entity.Dormitory;
import com.city.app.dao.entity.PowerRate;
import com.city.app.dao.entity.Room;
import com.city.app.dao.entity.WaterRate;
import com.city.app.dao.mapper.DormitoryMapper;
import com.city.app.dao.mapper.PowerRateMapper;
import com.city.app.dao.mapper.WaterRateMapper;
import com.city.app.service.IDormitoryService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: DormitoryServiceImpl
 * @Description: 寝室信息业务模块 错误码 13001 - 13999
 * @Author: CitySpring
 */

@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory> implements IDormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private WaterRateMapper waterMapper;

    @Autowired
    private PowerRateMapper powerRateMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result getDorInfoByUserId(String token) {
        String userId = getUserId(token);
        if(Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        DormitoryVo dormitory = dormitoryMapper.getDorInfoByUserId(Long.parseLong(userId));
        if(dormitory == null){
            return Result.fail("寝室信息查询失败", 13001);
        }

        return Result.success(null, dormitory);
    }

    @Override
    public Result getDorWaterInfo(String token) {
        String userId = getUserId(token);
        if(Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        CostVo costVo = dormitoryMapper.getDorWaterInfo(Long.parseLong(userId));
        if(costVo == null){
            return Result.fail("水费查询失败", 13002);
        }
        costVo.setOverdue(costVo.getCost() < 0);

        return Result.success(null, costVo);
    }

    @Override
    public Result getDorPowerInfo(String token) {
        String userId = getUserId(token);
        if(Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        CostVo costVo = dormitoryMapper.getDorPowerInfo(Long.parseLong(userId));
        if(costVo == null){
            return Result.fail("电费查询失败", 13003);
        }
        costVo.setOverdue(costVo.getCost() < 0);

        return Result.success(null, costVo);
    }

    @Override
    public Result getDorGradeInfo(String token) {
        String userId = getUserId(token);
        if(Strings.isBlank(userId)){
            return Result.fail("登录状态已过期", 10005);
        }

        GradeVo gradeVo = dormitoryMapper.getDorGradeInfo(Long.parseLong(userId));
        if(gradeVo == null){
            return Result.fail("卫生得分查询失败", 13004);
        }

        return Result.success(null, gradeVo);
    }

    @Override
    public Result UpdateDorWater(PayParam payParam) {
        WaterRate water = waterMapper.selectById(payParam.getId());
        if(water == null){
            return Result.fail("暂无水费信息", 13005);
        }

        water.setCost(water.getCost() + payParam.getAmount());
        if(waterMapper.updateById(water) > 0){
            return Result.success("缴费成功", water);
        }

        return Result.fail("缴费失败，请稍后再试", 13007);
    }

    @Override
    public Result UpdateDorPower(PayParam payParam) {
        PowerRate powerRate = powerRateMapper.selectById(payParam.getId());
        if(powerRate == null){
            return Result.fail("暂无电费信息", 13006);
        }

        powerRate.setCost(powerRate.getCost() + payParam.getAmount());
        if(powerRateMapper.updateById(powerRate) > 0){
            return Result.success("缴费成功", powerRate);
        }

        return Result.fail("缴费失败，请稍后再试", 13008);
    }

    @Override
    public Result getDorBuilding() {
        List<BuildingVo> buildings = dormitoryMapper.getDorBuilding();
        if(buildings.isEmpty()){
            return Result.fail("楼栋信息获取失败", 13009);
        }

        for (BuildingVo building : buildings) {
            List<Room> rooms = dormitoryMapper.getBuildingRooms(building.getId());
            building.setRooms(rooms);
        }

        return Result.success(null, buildings);
    }

    /**
     * 解析Token，获取userId
     * @param token 用户token
     */
    private String getUserId(String token){
        return stringRedisTemplate.opsForValue().get("TOKEN_" + token);
    }
}
