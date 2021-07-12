package com.cf.dao;

import com.cf.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:chenf
 * @Date:2021/7/11 22:19
 * @describe
 */
@Mapper
public interface UserInfoDao {
    UserInfo login(UserInfo userInfo);
}
