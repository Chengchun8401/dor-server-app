package com.city.app.common.vo;

import lombok.Data;

/**
 * @version v1.0
 * @ClassName: PageVo
 * @Description: 通用分页返回参数
 * @Author: CitySpring
 */
@Data
public class PageVo {

    private Long total;

    private Object data;

}
