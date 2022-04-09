package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CDUY
 * @version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {

        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {

        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^-^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book) {

        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {

        return new R(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {

        return new R(true, bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(true, bookService.getPage(currentPage, pageSize));
    }
}
