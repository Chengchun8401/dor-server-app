package com.city.app.common.vo;

import lombok.Data;

/**
 * @version v1.0
 * @ClassName: UserVo
 * @Description: 用户基础信息
 * @Author: CitySpring
 */
@Data
public class UserVo {

    /**
     * 学号
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 专业
     */
    private String major;

    /**
     * 寝室号
     */
    private String room;

    /**
     * 楼栋
     */
    private String building;

    /**
     * 卫生得分
     */
    private Integer score;



}
