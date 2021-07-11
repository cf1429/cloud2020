package com.cf.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:chenf
 * @Date:2021/7/11 17:02
 * @describe JWT工具类
 */
public class JWTUtils {
    private static final String SING = "!QAZWSX234EDCRFV45TGB6YHNUJM78KKI";

    /**
     * 生成token，header.payload.sing
     * @return
     */
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);   //默认7天过期
        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        // 将map中的payload 放入
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        String token = builder.withExpiresAt(instance.getTime()) // 指定令牌过期时间
                .sign(Algorithm.HMAC256(SING));// sign
        return token;
    }

    /**
     * 验证token 合法性
     * @param token
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }


}
