package com.atguigu.springcloud;

import com.atguigu.springcloud.dao.BookDao;
import com.atguigu.springcloud.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class Test {

    /*private BookDao bookDao;

    @org.junit.jupiter.api.Test
    public void testFindAll(){
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<Book> all = bookDao.findAll(pageRequest);
        System.out.println(all);


    }*/

}
