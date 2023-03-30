package com.city.app.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @ClassName: WorkOrderVo
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@Data
public class WorkOrderVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;

    private String content;

    private Long userId;

    private LocalDateTime commitTime;

    private Integer status;

    private Integer typeId;

    private String type;
}
