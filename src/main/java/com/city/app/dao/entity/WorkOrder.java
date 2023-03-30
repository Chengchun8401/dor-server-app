package com.city.app.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @ClassName: WorkOrder
 * @Description: 报修工单信息
 * @Author: CitySpring
 */
@Data
public class WorkOrder {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;

    private String content;

    private Long userId;

    private LocalDateTime commitTime;

    private Integer status;

    private Integer typeId;

    @TableField(exist = false)
    private User user;

}
