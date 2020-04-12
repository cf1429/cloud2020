package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.UserDao;
import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public PageResult<List<User>> findAllUser(Map<String, Object> map) {
        List<User> list = userDao.findUserList(map);
        int num  = userDao.findUserListCount(map);
        PageResult<List<User>> pageResult =  new PageResult<List<User>>();
        pageResult.setData(list);
        pageResult.setPageIndex(Integer.valueOf(map.get("pageIndex").toString()));
        pageResult.setPageSize(Integer.valueOf(map.get("pageSize").toString()));
        pageResult.setTotal(num);
        return pageResult;
    }


    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }
}
