package com.ayris.startertest;

import com.ayris.starterdemo.config.KafkaMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private KafkaMonitor kafkaMonitor;


    @GetMapping("testPrintConfig")
    public String testPrintConfig() {
        return kafkaMonitor.printConfig();
    }

}
