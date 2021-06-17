package com.atguigu.springcloud;

import com.atguigu.springcloud.entity.SysUser;
import com.atguigu.springcloud.mapper.SysUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
@MapperScan(value = "com.atguigu.springcloud.mapper")
@SpringBootApplication
public class App 
{
    @Autowired
    SysUserMapper userMapper;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);

    }

    //@PostConstruct
//    public void jdbcInit(){
//        Date curDate = new Date();
//        List<GrantedAuthority> list = new ArrayList<>();
//        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+"USER");
//        list.add(authority);
//
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        SysUser sysUser = new SysUser(
//                "lisi",encoder.encode("456"),"李四",
//                true,true,true,true,curDate,curDate,list);
//        userMapper.insertSysUser(sysUser);
//
//
//        List<GrantedAuthority> list1 = new ArrayList<>();
//        GrantedAuthority authority1 = new SimpleGrantedAuthority("ROLE_"+"ADMIN");
//        list1.add(authority1);
//
//        SysUser sysUser1 = new SysUser(
//                "admin",encoder.encode("admin"),"管理员",
//                true,true,true,true,curDate,curDate,list1);
//        userMapper.insertSysUser(sysUser1);
//
//
//        List<GrantedAuthority> list2 = new ArrayList<>();
//        GrantedAuthority authority2 = new SimpleGrantedAuthority("ROLE_"+"READ");
//        list2.add(authority2);
//
//        SysUser sysUser2 = new SysUser(
//                "zhangsan",encoder.encode("123"),"张三",
//                true,true,true,true,curDate,curDate,list2);
//        userMapper.insertSysUser(sysUser2);



//    }


}
