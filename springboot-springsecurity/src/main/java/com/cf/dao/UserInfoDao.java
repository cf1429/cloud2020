package com.cf.dao;

import com.cf.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:chenf
 * @Date:2021/5/29 21:42
 * @describe
 */
public interface UserInfoDao extends JpaRepository<UserInfo,Long> {

    UserInfo findByUsername(String username);
}
