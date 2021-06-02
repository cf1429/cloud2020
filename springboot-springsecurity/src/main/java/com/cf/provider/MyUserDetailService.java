package com.cf.provider;

import com.cf.dao.UserInfoDao;
import com.cf.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:chenf
 * @Date:2021/6/2 15:03
 * @describe
 */
@Component
@Qualifier("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        User user = null;
        if(s != null ){
             userInfo = userInfoDao.findByUsername(s);
        }
        if(userInfo != null ){
            List<GrantedAuthority> list = new ArrayList<>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+userInfo.getRole());
            list.add(grantedAuthority);
            //创建user对象
            user = new User(userInfo.getUsername(),userInfo.getPassword(),list);
        }

        return user;
    }
}
