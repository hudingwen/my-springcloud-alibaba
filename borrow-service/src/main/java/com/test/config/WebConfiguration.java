package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import javax.annotation.Resource;

//采用OAuth2的Resttemplate可以自动为我们携带请求参数
@Configuration
public class WebConfiguration {

    @Resource
    OAuth2ClientContext context;

    @Bean
    public OAuth2RestTemplate restTemplate(){
        return new OAuth2RestTemplate(new ClientCredentialsResourceDetails(), context);
    }
}