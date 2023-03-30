package com.city.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.app.common.param.PayParam;
import com.city.app.dao.entity.Dormitory;
import com.city.app.common.vo.Result;

/**
 * @version v1.0
 * @InterfaceName: IDormitoryService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface IDormitoryService extends IService<Dormitory> {

    /**
     * 获取基本寝室信息
     * @param token 用户token
     */
    Result getDorInfoByUserId(String token);

    /**
     * 获取水费详情
     * @param token 用户token
     */
    Result getDorWaterInfo(String token);

    /**
     * 获取电费详情
     * @param token 用户token
     */
    Result getDorPowerInfo(String token);

    /**
     * 获取分数详情
     * @param token 用户token
     */
    Result getDorGradeInfo(String token);

    /**
     * 缴纳水费
     * @param payParam 缴费参数
     */
    Result UpdateDorWater(PayParam payParam);

    /**
     * 缴纳电费
     * @param payParam 缴费参数
     */
    Result UpdateDorPower(PayParam payParam);

    /**
     * 获取楼栋信息
     */
    Result getDorBuilding();
}
