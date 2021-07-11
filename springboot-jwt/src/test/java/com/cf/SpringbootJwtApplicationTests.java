package com.cf;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootJwtApplicationTests {
    // 生成token
    @Test
    void contextLoads() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,100);
        Map<String,Object> map = new HashMap<String,Object>();
        String sign = JWT.create()
                .withHeader(map)
                .withClaim("userId", 1)   //payload
                .withClaim("username", "xiaochen")
                .withExpiresAt(instance.getTime())   // 过期时间
                .sign(Algorithm.HMAC256("kjkjk@"));// 签名
        System.out.println(sign);
    }
    // 验证token
    @Test
    public void test(){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("kjkjk@")).build();
        DecodedJWT verify = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MjU5OTMzODgsInVzZXJJZCI6MSwidXNlcm5hbWUiOiJ4aWFvY2hlbiJ9.Et2ujYCt2d3s83SfaY965Q7yvC1AbVTGfY-pdW0GFfQ");
        System.out.println(verify.getClaims().get("userId").asInt());
        System.out.println(verify.getClaims().get("username").asString());
        System.out.println("过期时间："+verify.getExpiresAt());
    }

}
