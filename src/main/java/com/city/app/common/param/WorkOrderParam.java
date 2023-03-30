package com.city.app.common.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: WorkOrderParam
 * @Description: 工单提交参数
 * @Author: CitySpring
 */
@Data
@ApiModel("工单提交参数")
public class WorkOrderParam {

    @ApiModelProperty("工单标题")
    private String title;

    @ApiModelProperty("工单类型")
    private Integer typeId;

    @ApiModelProperty("工单内容")
    private String content;

    @ApiModelProperty("人脸信息")
    private String face;

}
