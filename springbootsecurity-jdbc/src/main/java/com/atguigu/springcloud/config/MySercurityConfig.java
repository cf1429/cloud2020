package com.atguigu.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author:chenf
 * @Date:2021/6/13 19:04
 * @describe
 */
//@Configuration
public class MySercurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    @Qualifier("jdbcUserDetailsService")
//    private UserDetailsService userDetailsService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.userDetailsService(userDetailsService);
//    }
}
