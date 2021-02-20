package com.atguigu.cloud.entiy;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    //对应数据库主键，数据库主键配置策略有（uuid，数据库自增，redis，zookeeper等等）
    @TableId(type = IdType.AUTO)   // 全局唯一id,默认,其他策略可以通过IdType来配置
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
