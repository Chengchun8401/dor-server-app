package com.city.app.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version v1.0
 * @ClassName: Result
 * @Description: 前后端数据通信协议
 * @Author: CitySpring
 */
@Data
@AllArgsConstructor
public class Result {

    private Boolean success;

    private Integer code;

    private String msg;

    private Object data;

    public static Result success(String msg, Object data){
        return new Result(true, 200, msg, data);
    }

    public static Result fail(String msg, Integer code){
        return new Result(false, code, msg, null);
    }

}
