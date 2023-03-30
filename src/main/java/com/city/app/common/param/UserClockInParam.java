package com.city.app.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @ClassName: UserClockInParam
 * @Description: 用户打卡参数
 * @Author: CitySpring
 */
@Data
@ApiModel("用户打卡参数")
public class UserClockInParam {

    @ApiModelProperty("打卡地点")
    private String address;

    @ApiModelProperty("人脸信息")
    private String face;

}
