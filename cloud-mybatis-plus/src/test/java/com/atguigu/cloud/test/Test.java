package com.atguigu.cloud.test;

import com.atguigu.cloud.entiy.User;
import com.atguigu.cloud.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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
    //测试乐观锁成功案例
    @org.junit.Test
    public void successOptimisticLockerInnerInterceptor(){
        // 查询用户信息
        User user = userMapper.selectById(1L);
        user.setName("测试乐观锁");
        user.setAge(20);
        int result = userMapper.updateById(user);
        log.info("更新结果："+result);
    }
    // 测试乐观锁失败案例
    @org.junit.Test
    public void failOptimisticLockerInnerInterceptor(){
        User user = userMapper.selectById(1L);
        user.setName("测试乐观锁失败1");
        user.setAge(10);

        User user1 = userMapper.selectById(1L);
        user1.setName("测试乐观锁失败2");
        user1.setAge(30);
        userMapper.updateById(user1);
        userMapper.updateById(user);  //第二条数据更新失败，数据没有更新到数据库
    }
   //测试查询
    @org.junit.Test
    public void testSelect(){
        // 批量查询
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);

        // 条件查询
        log.info("测试根据map查询");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","wanglu");
        List<User> users1 = userMapper.selectByMap(map);
        users1.forEach(System.out::println);
    }

}
