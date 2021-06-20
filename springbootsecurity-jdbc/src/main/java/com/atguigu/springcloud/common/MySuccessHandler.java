package com.atguigu.springcloud.common;

import com.atguigu.springcloud.vo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:chenf
 * @Date:2021/6/19 17:40
 * @describe
 */
@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {
    /**
     *
     * @param httpServletRequest    请求对象
     * @param httpServletResponse   应答对象
     * @param authentication        springsecurity框架验证用户信息成功后的封装类
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, 
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        //登录的用户信息验证成功后执行的方法
        httpServletResponse.setContentType("text/json;charset=utf-8");
        Result result = new Result();
        result.setCode(0);
        result.setError(1000);
        result.setMsg("登录成功");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream,result);
        outputStream.flush();
        outputStream.close();
//        PrintWriter writer = httpServletResponse.getWriter();
//        writer.println("{\"msg\":\"登录成功！\"}");
//        writer.flush();
//        writer.close();
    }
}
