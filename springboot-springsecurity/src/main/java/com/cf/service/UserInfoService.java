package com.cf.service;

import com.cf.entity.UserInfo;

/**
 * @Author:chenf
 * @Date:2021/5/29 21:44
 * @describe
 */
public interface UserInfoService {
    UserInfo findByUsername(String username);
}
