package com.city.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.city.app.common.param.UserBindParam;
import com.city.app.common.param.UserFaceParam;
import com.city.app.dao.entity.User;
import com.city.app.common.param.UserLoginParam;
import com.city.app.common.param.UserRegistryParam;
import com.city.app.common.vo.Result;

/**
 * @version v1.0
 * @InterfaceName: IUserService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */

public interface IUserLoginService extends IService<User> {
    /**
     * 使用学号登录
     */
    Result userLogin(UserLoginParam param);

    /**
     * 人脸注册
     */
    Result userRegistry(UserRegistryParam param);

    /**
     * 注销账号
     */
    Result userLogout(String token);

    /**
     * 人脸登录
     */
    Result userLoginByFace(UserFaceParam param);

    /**
     * 获取用户信息
     */
    Result getUserInfo(String token);

    /**
     * 获取专业信息
     */
    Result getMajorInfo();

    /**
     * 绑定宿舍信息
     */
    Result bindDorInfo(UserBindParam param, String token);
}
