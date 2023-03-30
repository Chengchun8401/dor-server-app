package com.city.app.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: SuggestionParam
 * @Description: 用户留言参数
 * @Author: CitySpring
 */
@Data
@ApiModel("用户留言参数")
public class SuggestionParam {

    @ApiModelProperty("留言内容")
    private String content;

}
