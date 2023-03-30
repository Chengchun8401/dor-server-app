package com.city.app.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: Building
 * @Description: 楼栋信息
 * @Author: CitySpring
 */
@Data
public class Building {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String address;

    private String name;

}
