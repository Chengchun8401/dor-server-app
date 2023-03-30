package com.city.app.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.city.app.common.vo.UserVo;
import com.city.app.dao.entity.Major;
import com.city.app.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @ClassName: UserMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 账号登录
     * @param userId 学号
     */
    User loginByUserId(@Param("userId") Long userId);

    /**
     * 获取用户信息
     * @param userId 学号
     */
    UserVo getUserInfo(@Param("userId") Long userId);

    /**
     * 获取专业信息列表
     */
    List<Major> getMajorInfo();

}
