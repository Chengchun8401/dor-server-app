package com.city.app.controller;

import com.city.app.common.param.UserBindParam;
import com.city.app.common.param.UserFaceParam;
import com.city.app.service.IUserLoginService;
import com.city.app.common.param.UserLoginParam;
import com.city.app.common.param.UserRegistryParam;
import com.city.app.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @version v1.0
 * @ClassName: UserLoginController
 * @Description: 用户信息模块
 * @Author: CitySpring
 */
@Api(tags = "API-用户信息模块")
@RestController
@RequestMapping("/dor/user")
public class UserLoginController {

    @Autowired
    private IUserLoginService userLoginService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result userLogin(@RequestBody UserLoginParam param){
        return userLoginService.userLogin(param);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("info")
    public Result getUserInfo(@RequestHeader("Authorization") String token){
        return userLoginService.getUserInfo(token);
    }

    @ApiOperation("人脸登录")
    @PostMapping("/face")
    public Result userLoginByFace(@RequestBody UserFaceParam param){
        return userLoginService.userLoginByFace(param);
    }

    @ApiOperation("用户注册")
    @PostMapping("/registry")
    public Result userRegistry(@RequestBody UserRegistryParam param){
        return userLoginService.userRegistry(param);
    }

    @ApiOperation("注销登录")
    @GetMapping("/logout")
    public Result userLogout(@RequestHeader("Authorization") String token){
        return userLoginService.userLogout(token);
    }

    @ApiOperation("获取专业信息")
    @GetMapping("/major")
    public Result getMajorInfo(){
        return userLoginService.getMajorInfo();
    }

    @ApiOperation("绑定寝室信息")
    @PostMapping("")
    public Result bindDorInfo(@RequestBody UserBindParam param, @RequestHeader("Authorization") String token){
        return userLoginService.bindDorInfo(param, token);
    }

}
