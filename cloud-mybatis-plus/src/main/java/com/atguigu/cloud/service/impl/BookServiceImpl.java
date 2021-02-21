package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entiy.Book;
import com.atguigu.cloud.mapper.BookMapper;
import com.atguigu.cloud.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cf
 * @since 2021-02-21
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
