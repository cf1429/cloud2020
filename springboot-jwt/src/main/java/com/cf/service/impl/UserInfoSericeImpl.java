package com.cf.service.impl;

import com.cf.dao.UserInfoDao;
import com.cf.entity.UserInfo;
import com.cf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:chenf
 * @Date:2021/7/11 22:34
 * @describe
 */
@Service
@Transactional
public class UserInfoSericeImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public UserInfo login(UserInfo userInfo) {
        UserInfo u = userInfoDao.login(userInfo);
        if(u != null){
            return u;
        }else {
            throw new RuntimeException("登录失败---");
        }

    }
}
