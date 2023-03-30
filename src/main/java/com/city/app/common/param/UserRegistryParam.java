package com.city.app.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @version v1.0
 * @ClassName: UserRegistryParam
 * @Description: 用户注册参数
 * @Author: CitySpring
 */

@Data
@ApiModel("用户注册参数")
public class UserRegistryParam {

    @ApiModelProperty("人脸信息")
    private String face;

    @ApiModelProperty("学号ID")
    private String id;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("专业ID")
    private Integer majorId;
}
