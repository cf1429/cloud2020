package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/api/book/findAllBook/{pageIndex}/{pageSize}")
    public CommonResult<PageResult<List<Book>>> findAllBook(
            @PathVariable("pageSize") Integer pageSize, @PathVariable("pageIndex")Integer pageIndex){
        CommonResult<PageResult<List<Book>>> commonResult = new CommonResult<>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        PageResult<List<Book>> bookList = bookService.findAllBook(map);
        if(bookList != null){
            commonResult.setCode(200);
            commonResult.setData(bookList);
        }else{
            commonResult.setCode(404);
            commonResult.setMessage("没有查到有效信息");
        }
        return commonResult;
    }

    @PostMapping("/api/book/addBook")
    public CommonResult<String> addBook(@RequestBody Book book){
        CommonResult<String> commonResult = new CommonResult<>();
        int num = bookService.create(book);
        if(num >0 ){
            commonResult.setData("添加成功");
            commonResult.setCode(200);
        }else{
            commonResult.setMessage("添加失败");
            commonResult.setCode(404);
        }
        return commonResult;
    }

    @PostMapping(value = "/api/book/findBookById")
    public CommonResult<Book> findBookById(@RequestBody Book book){
        CommonResult<Book> commonResult = new CommonResult<>();
        Book book1 = bookService.findBookById(Integer.valueOf(book.getId()));
        if(book1 != null ){
            commonResult.setData(book1);
            commonResult.setCode(200);
        }else{
            commonResult.setMessage("系统异常");
            commonResult.setCode(404);
        }
        return commonResult;
    }

    @PostMapping(value = "/api/book/updateBook")
    public CommonResult<String> updateBook(@RequestBody Book book){
        CommonResult<String> commonResult = new CommonResult<>();
        int num = bookService.updateBook(book);
        if(num >0 ){
            commonResult.setData("修改成功");
            commonResult.setCode(200);
        }else{
            commonResult.setMessage("修改失败");
            commonResult.setCode(404);
        }
        return commonResult;
    }

    @DeleteMapping(value = "/api/book/deleteBook/{id}")
    public CommonResult<String> deleteBook(@PathVariable(value = "id") String id){
        CommonResult<String> commonResult = new CommonResult<>();
        int num = bookService.deleteBook(Integer.valueOf(id));
        if(num >0 ){
            commonResult.setData("修改成功");
            commonResult.setCode(200);
        }else{
            commonResult.setMessage("修改失败");
            commonResult.setCode(404);
        }
        return commonResult;
    }


}
