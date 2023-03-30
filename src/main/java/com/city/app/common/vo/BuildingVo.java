package com.city.app.common.vo;


import com.city.app.dao.entity.Room;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @version v1.0
 * @ClassName: BuildingVo
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
public class BuildingVo {

    /**
     * 楼栋ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 楼栋名称
     */
    private String name;

    /**
     * 寝室房间
     */
    private List<Room> rooms;

}
