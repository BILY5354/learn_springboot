package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CDUY
 * @version 1.0
 */
@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(11));
    }


    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试添加新书本类型");
        book.setName("测试添加新书本名字");
        book.setDescription("测试添加新书本简介");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(13);
        book.setType("计算机理论");
        book.setName("Java技术");
        book.setDescription("卷一卷二带你走向Java巅峰");
        bookService.update(book);
    }

    @Test
    void testDeleteById() {
        bookService.delete(16);
    }

    @Test
    void testGetAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    void testGetPage() {
        IPage<Book> page = bookService.getPage(1, 3);
        System.out.println(page);
    }

}
