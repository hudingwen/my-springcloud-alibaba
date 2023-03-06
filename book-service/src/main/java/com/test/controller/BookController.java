package com.test.controller;


import com.hudingwen.entity.Book;
import com.test.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope //添加此注解就能实现配置自动刷新
public class BookController {

    @Resource
    BookService service;

    @Value("${test}")
    String test;

    @RequestMapping("/test")
    public String test(){
        return test;
    }

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid){
        System.out.println("进入book服务");
        return service.getBookById(bid);
    }
}
