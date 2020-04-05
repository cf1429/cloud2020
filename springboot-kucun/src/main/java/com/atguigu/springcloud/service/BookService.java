package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAllBook();
}
