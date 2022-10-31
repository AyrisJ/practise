package com.ayris.rabbitmqtest.controller;

import com.ayris.rabbitmqtest.consume.BusinessLogService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessLogController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    BusinessLogService businessLogService;


    @GetMapping("hello")
    public void hello() {
        rabbitTemplate.convertAndSend("my-ex-topic-log", "businessLog", "hello rabbitmq");
    }


}
