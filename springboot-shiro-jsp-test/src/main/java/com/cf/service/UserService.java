package com.cf.service;

import com.cf.entity.User;

/**
 * @Author:chenf
 * @Date:2021/4/24 23:31
 * @describe
 */
public interface UserService {
    public void save(User user);

    public User getUserByName(String name);
}
