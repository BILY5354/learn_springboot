package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

/**
 * @author CDUY
 * @version 1.0
 */
public interface IBookService extends IService<Book> {

    IPage<Book> getPage(int currentPage, int pageSize);
}
