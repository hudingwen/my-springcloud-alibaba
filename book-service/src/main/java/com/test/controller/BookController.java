package com.test.controller;


import com.test.entity.Book;
import com.test.service.BookService;
import io.seata.core.context.RootContext;
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
        return service.getBookById(bid);
    }

    @RequestMapping("/book/remain/{bid}")
    public int bookRemain(@PathVariable("bid") int uid){
        System.out.println(RootContext.getXID());
        return service.getRemain(uid);
    }

    @RequestMapping("/book/borrow/{bid}")
    public boolean bookBorrow(@PathVariable("bid") int uid){
        int remain = service.getRemain(uid);
        return service.setRemain(uid, remain - 1);
    }
}
