package com.atguigu.springcloud.entity;

import java.io.Serializable;

/**
 * @Author:chenf
 * @Date:2021/6/16 13:39
 * @describe
 */
public class SysRole {
    private Integer id;
    private String rolename;
    private String rolememo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolememo() {
        return rolememo;
    }

    public void setRolememo(String rolememo) {
        this.rolememo = rolememo;
    }
}
