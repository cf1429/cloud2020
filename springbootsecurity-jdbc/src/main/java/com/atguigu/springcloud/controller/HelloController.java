package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chenf
 * @Date:2021/6/13 19:12
 * @describe
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello JdbcUser";
    }
}
