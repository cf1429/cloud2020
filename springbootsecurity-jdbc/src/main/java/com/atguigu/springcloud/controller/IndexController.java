package com.atguigu.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author:chenf
 * @Date:2021/6/16 15:04
 * @describe
 */
@Controller
public class IndexController {
    @GetMapping("/index")
    public String toIndexHtml(){
        return "forward:/index.html";
    }
}
