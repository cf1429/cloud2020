package com.cf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chenf
 * @Date:2021/5/28 11:27
 * @describe
 */
@RestController
@RequestMapping("/hello")
public class HelloSecurity {
    @RequestMapping("/sayHello")
    public String  sayHello(){
        return "hello security";
    }
}
