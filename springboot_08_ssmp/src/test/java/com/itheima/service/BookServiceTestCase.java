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
        book.setId(12);
        book.setType("测试更新类型");
        book.setName("测试更新书名");
        book.setDescription("测试更新简介");
        bookService.update(book);
    }

    @Test
    void testDeleteById() {
        bookService.delete(13);
    }

    @Test
    void testGetAll() {
        System.out.println(bookService.getAll());
    }

    @Test
    void testGetPage() {
        IPage<Book> page = bookService.getPage(1, 5);
    }

}
