package com.city.app.dao.entity;

import lombok.Data;

/**
 * @version v1.0
 * @ClassName: User
 * @Description: 学生
 * @Author: CitySpring
 */
@Data
public class User {

    /**
     * 学生学号
     */
    private Long id;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 寝室ID
     */
    private Long dormitoryId;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 专业
     */
    private Integer majorId;

}
