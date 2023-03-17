package com.test;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//开启oauth2
@EnableResourceServer
//开启全局事务数据源代理
@EnableAutoDataSourceProxy
//开启OpenFeign实现负载均衡
@EnableFeignClients
@SpringBootApplication
public class BorrowApplication {
    public static void main(String[] args) {
        SpringApplication.run(BorrowApplication.class);
    }
}
