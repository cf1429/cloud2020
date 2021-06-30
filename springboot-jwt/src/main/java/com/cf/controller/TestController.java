package com.cf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:chenf
 * @Date:2021/6/29 22:53
 * @describe
 */
@RestController
public class TestController  {
    @RequestMapping(value = "/test/login")
    public String login(String username, HttpServletRequest request){
        request.getSession().setAttribute("username",username);
        return "login-";
    }
}
