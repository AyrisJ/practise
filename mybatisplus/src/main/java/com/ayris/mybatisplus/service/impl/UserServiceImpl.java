package com.ayris.mybatisplus.service.impl;

import com.ayris.mybatisplus.dao.UserDao;
import com.ayris.mybatisplus.domain.User;
import com.ayris.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {


}
