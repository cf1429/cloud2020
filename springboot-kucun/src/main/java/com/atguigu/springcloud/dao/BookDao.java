package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookDao{
    public List<Book> findAllBook(Map<String,Object> map);
    public Integer findAllBookCount(Map<String,Object> map);
    public int create(Book book);
    public Book findBookById(Integer id);
    public int updateBook(Book book);
    public int deleteBook(Integer id);



}
