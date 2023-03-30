package com.city.app.config;

import com.alibaba.fastjson.JSON;
import com.city.app.utils.TokenService;
import com.city.app.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断请求的接口路径 是否为HandlerMethod（controller方法）
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        //判断swagger放行
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        if("springfox.documentation.swagger.web.ApiResourceController".equals(handlerMethod.getBean().getClass().getName())){
            return true;
        }

        String token = request.getHeader("Authorization");

        if(!tokenService.checkToken(token)){
            // 未登录
            Result result = Result.fail("未登录用户无权限访问", 1003);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }

        // 登录验证成功，放行
        return true;
    }

}
