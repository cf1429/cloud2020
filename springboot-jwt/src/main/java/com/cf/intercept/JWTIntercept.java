package com.cf.intercept;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.cf.utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:chenf
 * @Date:2021/7/15 18:05
 * @describe jwt拦截器
 */
@Slf4j
public class JWTIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Map<String,Object> map = new HashMap<>();
        log.info("输入的token为：{{}}",token);
        try {
            JWTUtils.verify(token);
            return true;
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
        // 将map转为json，然后将map的json数据返回给前端
        String jsonStr = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(jsonStr);
        return false;
    }
}
