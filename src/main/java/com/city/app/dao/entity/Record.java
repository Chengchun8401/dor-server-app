package com.city.app.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @ClassName: Record
 * @Description: 打卡记录信息
 * @Author: CitySpring
 */
@Data
public class Record {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String userId;

    private String address;

    private LocalDateTime time;

    private Integer typeId;

}
