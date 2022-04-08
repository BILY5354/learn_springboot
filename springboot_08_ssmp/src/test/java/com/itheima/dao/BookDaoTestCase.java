package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.print.PSPrinterJob;

/**
 * @author CDUY
 * @version 1.0
 */
@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(11));
    }


    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试添加新书本类型");
        book.setName("测试添加新书本名字");
        book.setDescription("测试添加新书本简介");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(12);
        book.setType("测试更新类型");
        book.setName("测试更新书名");
        book.setDescription("测试更新简介");
        bookDao.updateById(book);
    }

    @Test
    void testDeleteById() {
        bookDao.deleteById(12);
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);
        bookDao.selectPage(page, null);
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");//查询有spring的字段书名
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2() {
        String name = null;
        //与testGetBy一样，但是可以避免写字段错误
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        //判断的字段不能为空
        lqw.like(name != null, Book::getName, name);
        bookDao.selectList(lqw);
    }
}
