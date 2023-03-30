package com.city.app.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: PayParam
 * @Description: 缴费参数
 * @Author: CitySpring
 */
@Data
@ApiModel("缴费参数")
public class PayParam {

    @ApiModelProperty("费用ID")
    private String id;

    @ApiModelProperty("缴费金额")
    private Float amount;

}
