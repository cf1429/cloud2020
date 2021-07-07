package com.cf;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootJwtApplicationTests {

    @Test
    void contextLoads() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,20);


        Map<String,Object> map = new HashMap<String,Object>();
        String sign = JWT.create()
                .withHeader(map)
                .withClaim("userId", 1)   //payload
                .withClaim("username", "xiaochen")
                .withExpiresAt(instance.getTime())   // 过期时间
                .sign(Algorithm.HMAC256("kjkjk@"));// 签名

        System.out.println(sign);


    }

}
