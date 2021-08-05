package com.cf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cf.entity.Product;

/**
 * @Author:chenf
 * @Date:2021/8/5 15:26
 * @describe
 */

public interface ProductService extends IService<Product> {
    public Product getProductInfo(String id);
}
