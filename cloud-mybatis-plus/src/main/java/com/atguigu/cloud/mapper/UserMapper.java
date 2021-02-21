package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entiy.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    public List<Map<String,Object>> selectAlll();

}
