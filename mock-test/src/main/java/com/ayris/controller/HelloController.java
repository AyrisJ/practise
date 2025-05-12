package com.ayris.controller;


import com.ayris.entity.User;
import com.ayris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("getUser")
    public User getUser(Integer id) {
        return userService.getUser(id);
    }
}
