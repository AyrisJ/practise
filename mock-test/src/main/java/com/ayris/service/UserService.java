package com.ayris.service;

import com.ayris.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("name" + id);
        return user;
    }
}
