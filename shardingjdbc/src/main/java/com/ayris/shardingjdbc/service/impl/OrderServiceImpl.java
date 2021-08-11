package com.ayris.shardingjdbc.service.impl;

import com.ayris.shardingjdbc.domain.Order;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ayris.shardingjdbc.service.OrderService;
import com.ayris.shardingjdbc.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
implements OrderService{

}




