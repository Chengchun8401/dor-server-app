package com.city.app.controller;

import com.city.app.service.IRecordService;
import com.city.app.common.param.UserClockInParam;
import com.city.app.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName: UserSignInController
 * @Description: 用户打卡模块
 * @Author: CitySpring
 */
@Api(tags = "API-用户打卡模块")
@RestController
@RequestMapping("/dor/user/card")
public class UserClockInController {

    @Autowired
    private IRecordService recordService;

    /**
     * 获取用户打卡信息
     */
    @ApiOperation("获取用户打卡信息")
    @GetMapping("")
    public Result getUserClockInfo(@RequestHeader("Authorization") String token){
        return recordService.getUserClockInfo(token);
    }

    /**
     * 用户打卡
     */
    @ApiOperation("用户进行打卡")
    @PostMapping("")
    public Result userClockIn(@RequestBody UserClockInParam param, @RequestHeader("Authorization") String token){
        return recordService.userClockIn(param, token);
    }

}
