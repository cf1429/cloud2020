package com.cf.service.impl;

import com.cf.dao.UserDao;
import com.cf.entity.User;
import com.cf.service.UserService;
import com.cf.util.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:chenf
 * @Date:2021/4/24 23:24
 * @describe
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao ;
    @Override
    public void save(User user){
        //生成随机盐
        String salt = SaltUtil.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
        userDao.save(user);

    }

    @Override
    public User getUserByName(String name) {
        return userDao.findByUserName(name);
    }
}
