package com.city.app.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: Dormitory
 * @Description: 寝室信息
 * @Author: CitySpring
 */
@Data
public class Dormitory {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 楼栋Id
     */
    private Long buildingId;

    /**
     * 楼层Id
     */
    private Long baseId;

    /**
     * 寝室Id
     */
    private Long roomId;

    /**
     * 水费Id
     */
    private Long waterId;

    /**
     * 电费Id
     */
    private Long powerId;

    /**
     * 评分Id
     */
    private Long gradeId;

}
