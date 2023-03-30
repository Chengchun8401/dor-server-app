package com.city.app.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: Power
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
public class PowerRate {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Float cost;

    private Float amount;

}
