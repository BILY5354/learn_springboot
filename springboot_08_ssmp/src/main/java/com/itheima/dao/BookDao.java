package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author CDUY
 * @version 1.0
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

   /* mybatis的写法 但是mp无需
   @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);*/
}
