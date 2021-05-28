package com.cf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:chenf
 * @Date:2021/5/28 11:19
 * @describe
 */
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})  // 排除security安全验证
@SpringBootApplication
public class SpringSecurityMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityMain.class,args);
    }
}
