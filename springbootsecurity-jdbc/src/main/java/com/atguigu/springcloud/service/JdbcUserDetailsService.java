package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.SysRole;
import com.atguigu.springcloud.entity.SysUser;
import com.atguigu.springcloud.mapper.SysRoleMapper;
import com.atguigu.springcloud.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:chenf
 * @Date:2021/6/16 13:52
 * @describe
 */
@Service
public class JdbcUserDetailsService implements UserDetailsService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 1，根据username获取user账户信息
        SysUser sysUser = sysUserMapper.selectSysUser(s);
        if(sysUser != null ){
            System.out.println("查询到用户信息"+sysUser.toString());
            // 2.根据用户id获取角色信息
            List<SysRole> sysRoles = sysRoleMapper.selectSysRoleByUserId(sysUser.getId());
            System.out.println(sysRoles.toString());
            List<GrantedAuthority> authorities = new ArrayList<>();
            sysRoles.stream().forEach((e)->{
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+e.getRolename());
                authorities.add(authority);
            });
            sysUser.setAuthorities(authorities);
            return sysUser;
        }else{
            System.out.println("没有用户相关的信息");
        }
        return sysUser;
    }
}
