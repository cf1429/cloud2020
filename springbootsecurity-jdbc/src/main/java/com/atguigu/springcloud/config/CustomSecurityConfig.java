package com.atguigu.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author:chenf
 * @Date:2021/6/16 14:10
 * @describe
 */
@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        System.out.println("-=========httpSecurity----------");
        http.authorizeRequests()
                .antMatchers("/index").permitAll()   //这个请求放行，不进行认证
                .antMatchers("/access/user").hasRole("USER")
                .antMatchers("/access/admin").hasRole("ADMIN")
                .antMatchers("/access/read").hasRole("READ")
                .anyRequest().authenticated()   //其他请求需要认证
                .and()
                .formLogin();
    }


}
