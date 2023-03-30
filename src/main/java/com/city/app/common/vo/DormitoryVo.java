package com.city.app.common.vo;

import lombok.Data;

/**
 * @version v1.0
 * @ClassName: DormitoryVo
 * @Description: 寝室数据信息
 * @Author: CitySpring
 */
@Data
public class DormitoryVo {
    private Long id;

    /**
     * 楼栋
     */
    private String building;

    /**
     * 楼层
     */
    private String base;

    /**
     * 房间
     */
    private String room;

    /**
     * 水费
     */
    private Double water;

    /**
     * 电费
     */
    private Double power;

    /**
     * 评分
     */
    private Integer score;
}
