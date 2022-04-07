package com.itheima.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @author CDUY
 * @version 1.0
 */
@Repository
public class BookService implements BookDao {
    @Override
    public void save() {
        System.out.println("book save");
    }
}
