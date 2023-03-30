package com.city.app.config;

import com.city.app.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        // 记录到日志
        log.error("=============Exception start=============");
        log.error("Exception Msg: {}", e.toString());
        log.error("=============Exception end=============");
        return Result.fail("操作不合法或系统出现异常", -999);
    }

}
