package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/api/book/findAll")
    public CommonResult<List<Book>> findAllBook(){
        CommonResult<List<Book>> commonResult = new CommonResult<>();
        List<Book> bookList = bookService.findAllBook();
        if(bookList != null && bookList.size()>0){
            commonResult.setCode(200);
            commonResult.setData(bookList);
        }else{
            commonResult.setCode(404);
            commonResult.setMessage("没有查到有效信息");
        }
        return commonResult;
    }
}
