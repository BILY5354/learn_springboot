package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * @author CDUY
 * @version 1.0
 */
@SpringBootTest
public class BookServiceMPTestCase {

    @Autowired
    private IBookService bookService;


    /**
     * myBatis-plus的分页
     * */
    @Test
    void testGetPage(){
        IPage<Book> page = new Page<Book>(2,2);
        bookService.page(page);
    }
}
