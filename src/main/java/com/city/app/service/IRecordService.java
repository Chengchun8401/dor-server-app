package com.city.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.app.dao.entity.Record;
import com.city.app.common.param.UserClockInParam;
import com.city.app.common.vo.Result;

/**
 * @version v1.0
 * @InterfaceName: IRecordService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
public interface IRecordService extends IService<Record> {

    /**
     * 获取用户打卡信息
     * @param token 学生token
     */
    Result getUserClockInfo(String token);

    /**
     * 用户打卡
     */
    Result userClockIn(UserClockInParam param, String token);
}
