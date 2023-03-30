package com.city.app.common.param;

import lombok.Data;

/**
 * @version v1.0
 * @ClassName: UserBindParam
 * @Description: 绑定信息
 * @Author: CitySpring
 */
@Data
public class UserBindParam {

    /**
     * 楼栋id
     */
    private String buildingId;

    /**
     * 寝室号
     */
    private String roomId;

    /**
     * 性别
     */
    private Integer sex;

}
