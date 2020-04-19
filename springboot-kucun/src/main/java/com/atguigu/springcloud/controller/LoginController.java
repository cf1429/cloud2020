package com.atguigu.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.service.UserService;
import com.atguigu.springcloud.utils.EncryptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(value = {"/","/api/user"})
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public CommonResult<User> login(@RequestBody User user){
        log.info("调用登录接口........");
        CommonResult<User> comparable = new CommonResult();
        if(StrUtil.isBlank(user.getUserName()) || StrUtil.isBlank(user.getUserPassword())){
            comparable.setMessage("用户名和密码不能为空");
            return comparable;
        };
        User user1 = userService.findUserByUserName(user.getUserName());
        if(user1 == null){
            comparable.setMessage("用户名或密码错误");
            return comparable;
        }
        if(!EncryptionUtil.getMd5(user.getUserPassword()).equals(user1.getUserPassword())){
            comparable.setMessage("密码错误");
            return comparable;
        }else{
            comparable.setData(user);
            return comparable;
        }

    }



}
