package com.test.service.client;

import com.hudingwen.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient{
    @Override
    public User getUserById(int uid) {
        User user = new User();
        user.setName("我是替代方案");
        return user;
    }
}