package com.city.app.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version v1.0
 * @ClassName: Announcement
 * @Description: 公告信息
 * @Author: CitySpring
 */
@Data
public class Announcement {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 发布者
     */
    private String publisher;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

}
