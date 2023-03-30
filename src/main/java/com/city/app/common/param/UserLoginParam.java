package com.city.app.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: LoginParam
 * @Description: 用户登录参数
 * @Author: CitySpring
 */
@Data
@ApiModel("用户登录参数")
public class UserLoginParam {

    @ApiModelProperty("学号ID")
    private String username;

    @ApiModelProperty("登录密码")
    private String password;

}
