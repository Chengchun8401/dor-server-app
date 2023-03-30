package com.city.app.utils;

import com.city.app.dao.entity.User;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @version v1.0
 * @ClassName: JWTUtils
 * @Description: Token生成与校验
 * @Author: CitySpring
 */
public class JWTUtils {

    private static final String jwtToken = "City@8401#";

    /**
     * 根据用户信息生成token
     * @param  userInfo
     * @return  token
     */
    public static String createToken(String userInfo){
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("loginUsername", userInfo);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken)  // 签发算法，秘钥为jwtToken
                .setClaims(claims)  // body数据，要唯一，自行设置
                .setIssuedAt(new Date())  // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)); // 7天的有效时间
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token){
        try{
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String,Object>)parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}