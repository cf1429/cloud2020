package com.cf.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Payload;
import com.cf.entity.UserInfo;
import com.cf.service.UserInfoService;
import com.cf.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:chenf
 * @Date:2021/7/11 22:41
 * @describe
 */
@RestController
@Slf4j
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/user/login")
    public Map<String,Object> login(String username, String password){
        log.info("用户名："+username+" 密码："+password);
        Map<String,Object> map = new HashMap<String,Object>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        try {
            UserInfo login = userInfoService.login(userInfo);
            Map<String,String> payload = new HashMap<>();
            payload.put("id",login.getId()+"");
            payload.put("name",login.getUsername());
            // 生成jwt的令牌
            String token = JWTUtils.getToken(payload);
            map.put("state",true);
            map.put("msg","认证成功");
            map.put("token",token);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.toString());
        }
        return map;

    }

    /**
     * 验证token
     * @param token
     * @return
     */
    @GetMapping(value = "/user/test")
    public Map<String,Object> test(String token){
        Map<String,Object> map = new HashMap<>();
        log.info("输入的token为：{{}}",token);
        try {
            JWTUtils.verify(token);
            map.put("state",true);
            map.put("msg","请求成功！");
            return map;
        }catch (SignatureVerificationException e){
            map.put("msg","无效签名！");
            e.printStackTrace();
        }catch (TokenExpiredException e){
            map.put("msg","token过期！");
            e.printStackTrace();
        }catch (AlgorithmMismatchException e){
            map.put("msg","token算法不一致");
            e.printStackTrace();
        }catch (Exception e){
            map.put("msg","token无效!");
            e.printStackTrace();
        }
        map.put("state",false);

        return map;
    }
}
