package com.atguigu.cloud.test;

import com.atguigu.cloud.entiy.User;
import com.atguigu.cloud.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private UserMapper userMapper;

    @org.junit.Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @org.junit.Test
    public void testInsert(){
        User user = new User();
        user.setName("wanglu");
        user.setAge(3);
        user.setEmail("1429043932@qq.com");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    @org.junit.Test
    public void testUpdate(){
        User user = new User();
        user.setId(1362644586793328652L);
        user.setAge(20);
        user.setName("张柳");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }
}
