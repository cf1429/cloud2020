package com.atguigu.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/**
 * @Author:chenf
 * @Date:2021/6/13 18:53
 * @describe
 */
@Configuration
public class ApplicationConfig {
    // 通过spring容器注入DataSource对象
    @Autowired
    private DataSource dataSource;

    // 创建passwordEncoder对象
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    // 创建jdbcUserDetailsService对象
    @Bean(name = "jdbcUserDetailsService")
    public UserDetailsService jdbcUserDetailsService(){
        System.out.println("datasource====="+dataSource);
        PasswordEncoder encoder = encoder();
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        if(!manager.userExists("admin")){
            manager.createUser(User.withUsername("admin").password(encoder.encode("admin"))
                    .roles("ADMIN","USER","MANAGER").build());
        }
        if(!manager.userExists("zs")){
            manager.createUser(User.withUsername("zs").password(encoder.encode("123"))
                    .roles("User").build());

        }

        if(!manager.userExists("lisi")){
            manager.createUser(User.withUsername("lisi").password(encoder.encode("456")).
                    roles("User","NORMAL").build());

        }

        return manager;

    }


}
