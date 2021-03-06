package com.atguigu.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyConfig extends WebMvcConfigurationSupport {

    @Autowired
    UploadConfig uploadConfig;
    // 解决前后端分离跨域问题
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //放行哪些原始域
                        .allowedOrigins("*")
                        //是否发送Cookie信息
                        .allowCredentials(true)
                        //放行哪些原始域(请求方式)
                        .allowedMethods("GET","POST", "PUT", "DELETE")
                        //放行哪些原始域(头部信息)
                        .allowedHeaders("*")
                        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                        .exposedHeaders("Header1", "Header2");
            }
        };

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if(System.getProperty("os.name").toLowerCase().contains("linux")){
            registry.addResourceHandler(uploadConfig.getStaticAccessPath()+"/**").addResourceLocations("file:"+uploadConfig.getUploadPath());
        }else if(System.getProperty("os.name").toLowerCase().contains("windows")){
            registry.addResourceHandler(uploadConfig.getStaticAccessPath()+"/**").addResourceLocations("file:"+uploadConfig.getUploadPath());
        }
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //此处配置拦截路径

        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(uploadConfig.getStaticAccessPath()+"/**","/api/user/login",uploadConfig.getUploadPath()+"/**");
    }






}
