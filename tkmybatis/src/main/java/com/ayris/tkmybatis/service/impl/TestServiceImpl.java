package com.ayris.tkmybatis.service.impl;

import com.ayris.tkmybatis.base.IMapper;
import com.ayris.tkmybatis.domain.TOrder;
import com.ayris.tkmybatis.domain.TUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestServiceImpl {

    @Resource
    private IMapper<TUser> userMapper;

    @Resource
    private IMapper<TOrder> orderMapper;

    @GetMapping("selectList")
    public void selectOne() {
        List<TUser> userList = userMapper.select(new TUser());
        System.out.println(userList.size());

        List<TOrder> orderList = orderMapper.select(new TOrder());
        System.out.println(orderList.size());

    }

}
