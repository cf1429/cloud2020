package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    public List<Book> findAllBook();
}
