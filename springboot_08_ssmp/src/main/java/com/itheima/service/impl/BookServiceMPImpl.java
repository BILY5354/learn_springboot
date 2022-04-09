package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.stereotype.Service;

/**
 * @author CDUY
 * @version 1.0
 */
@Service
public class BookServiceMPImpl extends ServiceImpl<BookDao, Book> implements IBookService {
}
