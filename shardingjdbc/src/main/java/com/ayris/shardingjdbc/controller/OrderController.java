package com.ayris.shardingjdbc.controller;

import com.ayris.shardingjdbc.domain.Order;
import com.ayris.shardingjdbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("insert/batch")
    public void batchInsert() {
        List<Order> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            order.setId(UUID.randomUUID().toString().replace("-", ""));
            order.setSeqNo(String.valueOf(i));
            list.add(order);
        }
        orderService.saveBatch(list);
    }

}
