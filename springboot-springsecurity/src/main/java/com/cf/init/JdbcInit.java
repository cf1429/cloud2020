package com.cf.init;

/**
 * @Author:chenf
 * @Date:2021/6/2 14:51
 * @describe
 */

import com.cf.dao.UserInfoDao;
import com.cf.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 数据库初始化
 */
//@Component
public class JdbcInit {

    @Autowired
    private UserInfoDao userInfoDao;
    //@PostConstruct
    public void init(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(encoder.encode("123"));
        userInfo.setUsername("张三");
        userInfo.setRole("normal");
        userInfoDao.save(userInfo);

        userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword(encoder.encode("admin"));
        userInfo.setRole("admin");
        userInfoDao.save(userInfo);
    }
}
