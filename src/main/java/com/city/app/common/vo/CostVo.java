package com.city.app.common.vo;

import lombok.Data;

/**
 * @version v1.0
 * @ClassName: CostVo
 * @Description: 费用信息
 * @Author: CitySpring
 */
@Data
public class CostVo {

    private Long id;

    /**
     * 费用
     */
    private Float cost;

    /**
     * 用量
     */
    private Float amount;

    /**
     * 房间号
     */
    private String room;

    /**
     * 是否欠费
     */
    private Boolean overdue;

}
