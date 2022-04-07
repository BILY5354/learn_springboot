package com.itheima.controller;

import com.itheima.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${lesson}")
    private String lesson;

    @Value("${users[0].name}")
    private String name;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...2");
        System.out.println("lesson====>" + lesson);
        System.out.println("name====>" + name);
        System.out.println("================");
        System.out.println(myDataSource);
        return "springboot is running...2";
    }

}
