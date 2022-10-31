package com.ayris.rabbitmqtest;

import cn.hutool.core.collection.ListUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class RabbitmqTestApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void topicSendTestSimple() {
        rabbitTemplate.convertAndSend("my-ex-topic-log", "businessLog", "hello rabbitmq");
    }


    @Test
    void topicSendTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "hello rabbitmq");
        map.put("data", ListUtil.of("helloworld", 123456, true));

        rabbitTemplate.convertAndSend("my-ex-topic-log", "businessLog", map);
    }

    @Test
    void topicReceiveTest() {
        Object o = rabbitTemplate.receiveAndConvert("myBusiLog");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
