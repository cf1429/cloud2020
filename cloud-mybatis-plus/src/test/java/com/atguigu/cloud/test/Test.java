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
}
