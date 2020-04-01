package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/","/api/"})
@Slf4j
public class LoginController {

    @PostMapping(value = "login")
    public CommonResult<String> login(@RequestParam(value = "username",required = true) String username,
                                      @RequestParam(value = "password",required = false) String password){
        log.info("调用登录接口........");
        CommonResult<String> comparable = new CommonResult();
        if(username.equals(password)){
            comparable.setCode(200);
            comparable.setData("登录成功");
            log.info("账号和密码一样，登录成功.....");
        }else{
            comparable.setCode(404);
            comparable.setMessage("登录失败");
        }
        return comparable;
    }
}
