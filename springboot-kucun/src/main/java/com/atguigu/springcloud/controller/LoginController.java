package com.atguigu.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.service.RedisServie;
import com.atguigu.springcloud.service.UserService;
import com.atguigu.springcloud.utils.EncryptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping(value = {"/","/api/user"})
@Slf4j
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisServie redisServie;

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
            String token = UUID.randomUUID().toString().replace("-","");
            user.setToken(token);
            comparable.setData(user);

            redisServie.set(token,user);
            return comparable;
        }
    }

    public CommonResult<String> logout(HttpServletRequest request){
        CommonResult<String> commonResult = new CommonResult<>();
        String token = request.getHeader("token");
        Boolean delFlag = redisServie.delete(token);
        if(!delFlag){
            commonResult.setMessage("注销失败，请检查是否登录！");
        }else{
            commonResult.setData("注销成功");
        }
        return commonResult;

    }



}
