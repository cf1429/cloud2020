package com.cf.service;

import com.cf.dao.UserInfoDao;
import com.cf.entity.UserInfo;
import com.cf.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:chenf
 * @Date:2021/5/29 21:45
 * @describe
 */
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
