package com.city.app.common.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @version v1.0
 * @ClassName: GradeVo
 * @Description: 寝室分数信息
 * @Author: CitySpring
 */
@Data
public class GradeVo {

    private Long id;

    private Integer score;

    private LocalDate checkTime;

}
