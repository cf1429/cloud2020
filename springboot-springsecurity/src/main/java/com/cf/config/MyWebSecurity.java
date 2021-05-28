package com.cf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author:chenf
 * @Date:2021/5/28 15:24
 * @describe
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)  //启动角色认证
@Configuration
@EnableWebSecurity   //启用security安全框架的安全校验
public class MyWebSecurity extends WebSecurityConfigurerAdapter {
    //在方法中配置用户名和密码，作为用户登录的数据
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 给用户添加角色
        PasswordEncoder pe = passwordEncoder();
        auth.inMemoryAuthentication()
                .withUser("zhangsan")
                .password(pe.encode("123"))
                .roles("admin","normal");
        auth.inMemoryAuthentication()
                .withUser("lisi")
                .password(pe.encode("lisi"))// 对密码进行加密
                .roles("normal");
        auth.inMemoryAuthentication()
                .withUser("王五")
                .password(pe.encode("123"))
                .roles("admin");
    }

    //创建密码的加密类
    @Bean
    public PasswordEncoder passwordEncoder(){
        // 通过passwordEncoder的实现类，实现加密算法
        return new BCryptPasswordEncoder();
    }
}
