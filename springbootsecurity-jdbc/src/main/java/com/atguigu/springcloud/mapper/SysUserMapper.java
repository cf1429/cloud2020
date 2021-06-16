package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author:chenf
 * @Date:2021/6/14 18:07
 * @describe
 */
@Repository
public interface SysUserMapper {
    int insertSysUser(SysUser sysUser);

    SysUser selectSysUser(@Param("username") String username);
}
