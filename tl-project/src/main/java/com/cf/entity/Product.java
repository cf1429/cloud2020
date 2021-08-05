package com.cf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:chenf
 * @Date:2021/8/5 15:33
 * @describe
 */
@Data
public class Product implements Serializable {
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;
    @TableField(value = "product_name")
    private String productName;

}
