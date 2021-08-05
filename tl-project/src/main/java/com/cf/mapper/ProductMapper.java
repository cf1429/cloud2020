package com.cf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cf.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:chenf
 * @Date:2021/8/5 16:17
 * @describe
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
