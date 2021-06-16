package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entity.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:chenf
 * @Date:2021/6/16 13:39
 * @describe
 */
@Repository
public interface SysRoleMapper {
    List<SysRole> selectSysRoleByUserId(Integer userId);

}
