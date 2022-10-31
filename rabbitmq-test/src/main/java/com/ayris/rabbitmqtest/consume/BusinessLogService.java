package com.ayris.rabbitmqtest.consume;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BusinessLogService {


    @RabbitListener(queues = "myBusiLog")
    public void receiveBusinessLog(Message message) {
        System.out.println(message.getMessageProperties());;
        System.out.println("consume message from rabbitmq:" + new String(message.getBody()));

    }

}
