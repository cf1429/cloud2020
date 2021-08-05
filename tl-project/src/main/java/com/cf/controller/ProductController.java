package com.cf.controller;

import com.cf.entity.Product;
import com.cf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:chenf
 * @Date:2021/8/5 15:23
 * @describe
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/getProductInfo/{id}")
    public Product getProductInfo(@PathVariable(value = "id") String id){
        return productService.getProductInfo(id);
    }

}
