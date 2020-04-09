package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.BookDao;
import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.service.BookService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;
    @Override
    public PageResult<List<Book>> findAllBook(Map<String,Object> map) {
        List<Book> list = bookDao.findAllBook(map);
        int num  = bookDao.findAllBookCount(map);
        PageResult<List<Book>> pageResult =  new PageResult<List<Book>>();
        pageResult.setData(list);
        pageResult.setPageIndex(Integer.valueOf(map.get("pageIndex").toString()));
        pageResult.setPageSize(Integer.valueOf(map.get("pageSize").toString()));
        pageResult.setTotal(num);
        return pageResult;
    }

    @Override
    public int create(Book book) {
        return bookDao.create(book);
    }

    @Override
    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBook(Integer id) {
        return bookDao.deleteBook(id);
    }


}
