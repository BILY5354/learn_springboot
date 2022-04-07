package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author CDUY
 * @version 1.0
 */
@Mapper
@Component(value = "bookDao")
public interface BookDao extends BaseMapper<Book> {
}

