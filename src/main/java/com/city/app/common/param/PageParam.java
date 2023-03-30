package com.city.app.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: PageParam
 * @Description: 通用分页参数
 * @Author: CitySpring
 */
@Data
@ApiModel("分页参数")
public class PageParam {

    @ApiModelProperty("页码")
    private Integer page;

    @ApiModelProperty("页面大小")
    private Integer pageSize;
}
