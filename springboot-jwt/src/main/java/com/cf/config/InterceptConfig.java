package com.cf.config;

import com.cf.intercept.JWTIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:chenf
 * @Date:2021/7/15 18:19
 * @describe  加载自定义拦截器
 */
@Configuration
public class InterceptConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTIntercept())
                .addPathPatterns("/user/test")   // 正常情况下 拦截所有请求/**，因测试需要就先拦截/user/test
                .excludePathPatterns("/user/login");   //放心登录接口，因为要通过登录获取token

    }
}
