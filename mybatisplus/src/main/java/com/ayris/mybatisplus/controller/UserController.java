package com.ayris.mybatisplus.controller;

import com.ayris.mybatisplus.domain.User;
import com.ayris.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("page")
    public void page() {
        Page<User> page = new Page<>(1, 10);

        Page<User> result = userService.page(page);
        result.getRecords().forEach(System.out::println);

    }


}
