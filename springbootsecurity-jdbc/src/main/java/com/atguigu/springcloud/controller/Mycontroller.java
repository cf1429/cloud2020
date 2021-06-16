package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chenf
 * @Date:2021/6/16 14:46
 * @describe
 */
@RestController
public class Mycontroller {
    @GetMapping(value = "/access/user")
    public String sayUser(){
        return "user角色";
    }

    @GetMapping(value = "/access/admin")
    public String sayAdmin(){
        return "admin角色";
    }

    @GetMapping(value = "/access/read")
    public String sayRead(){
        return "read角色";
    }
}
