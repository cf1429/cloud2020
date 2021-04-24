package com.cf.dao;

import com.cf.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:chenf
 * @Date:2021/4/24 23:11
 * @describe
 */
@Mapper
public interface UserDao {
    void save(User user);
}
