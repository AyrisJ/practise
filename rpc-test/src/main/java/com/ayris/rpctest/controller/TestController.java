package com.ayris.rpctest.controller;

import com.alibaba.fastjson.JSON;
import com.ayris.rpctest.client.AmapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private AmapClient amapClient;


    @GetMapping("getLocation")
    public String testGetLocation() {
        String result = JSON.toJSONString(amapClient.getLocation("121.475078", "31.223577"));
        System.out.println(result);
        return result;
    }

    @GetMapping("hello")
    public String hello(String name) {
        System.out.println(name);
        return name;
    }

}
