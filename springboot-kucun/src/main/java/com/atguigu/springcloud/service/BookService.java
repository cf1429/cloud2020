package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.entities.PageResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

public interface BookService {
    public PageResult<List<Book>> findAllBook(Map<String,Object> map);
    public int create(Book book);
    public Book findBookById(Integer id);
    public int updateBook(Book book);
    public int deleteBook(Integer id);
}
