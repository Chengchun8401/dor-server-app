package com.city.app.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: Room
 * @Description: 房间信息
 * @Author: CitySpring
 */
@Data
public class Room {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private Long buildingId;

}
