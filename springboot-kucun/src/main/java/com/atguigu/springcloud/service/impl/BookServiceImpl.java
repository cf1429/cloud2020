package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.BookDao;
import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.service.BookService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;
    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }
}
