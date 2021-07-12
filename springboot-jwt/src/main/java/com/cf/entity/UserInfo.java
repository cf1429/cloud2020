package com.cf.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author:chenf
 * @Date:2021/7/11 22:17
 * @describe
 */
@Data
@Accessors(chain = true)
public class UserInfo {
    private int id;
    private String username;
    private String password;

}
