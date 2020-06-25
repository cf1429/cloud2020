package com.atguigu.springcloud;

import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    // 添加用户
    public int create(User user);
    // 修改用户
    public int updateUser(User user);
    // 用户列表查询
    public PageResult<List<User>> findAllUser(Map<String,Object> map);
    // 删除用户
    public int deleteUser(Integer id);
    // 根据id查找用户
    public User findUserById(Integer id);
    // 根据用户名查找用户信息
    public User findUserByUserName(String userName);

}
