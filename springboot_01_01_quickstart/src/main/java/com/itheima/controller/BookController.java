package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CDUY
 * @version 1.0
 */
@RestController
@RequestMapping("books")
public class BookController {

    @GetMapping
    public String getById() {
        String str = "springboot is running ...";
        System.out.println(str);
        return str;
    }
}
