package com.cf.service;

import com.cf.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:chenf
 * @Date:2021/7/11 22:32
 * @describe
 */
public interface UserInfoService {

    public UserInfo login(UserInfo userInfo);

}
