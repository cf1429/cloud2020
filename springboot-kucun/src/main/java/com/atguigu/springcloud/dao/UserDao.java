package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface UserDao {
    // 添加用户
    int create(User user);
    // 修改用户
    int updateUser(User user);
    // 用户列表查询
    List<User> findUserList(Map<String,Object> map);
    int findUserListCount(Map<String,Object> map);
    // 删除用户
    int deleteUser(Integer id);
    // 根据id查找用户
    User findUserById(Integer id);
    // 根据用户名查找用户信息
    User findUserByUserName(String userName);

}
