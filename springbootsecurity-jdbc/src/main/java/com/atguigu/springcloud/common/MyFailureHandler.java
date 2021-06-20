package com.atguigu.springcloud.common;

import com.atguigu.springcloud.vo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author:chenf
 * @Date:2021/6/19 17:45
 * @describe
 */
@Component
public class MyFailureHandler implements AuthenticationFailureHandler {
    /**
     *
     * @param httpServletRequest 请求对象
     * @param httpServletResponse  应答对象
     * @param e  springsecurity框架验证用户信息成功后的封装类
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
       //当框架验证用户信息失败时执行的方法
        httpServletResponse.setContentType("text/json;charset=utf-8");
        Result result = new Result();
        result.setCode(1);
        result.setError(1001);
        result.setMsg("登录失败");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream,result);
        outputStream.flush();
        outputStream.close();


//        PrintWriter writer = httpServletResponse.getWriter();
//        writer.println("{\"msg\":\"登录失败！\"}");
//        writer.flush();
//        writer.close();

    }
}
