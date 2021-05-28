package com.cf.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

    //指定角色是admin，normal的用户可以访问
    @RequestMapping("/helloUser")
    @PreAuthorize(value = "hasAnyRole('admin','normal')")
    public String helloUser(){
        return "Hello 拥有normal，admin角色用户";
    }

    //角色是admin的用户可以访问
    @RequestMapping("/helloAdmin")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String helloAdmin(){
        return "Hello 拥有admin角色的用户可以访问";

    }
}
