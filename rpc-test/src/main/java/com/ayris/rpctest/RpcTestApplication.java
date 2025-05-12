package com.ayris.rpctest;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ForestScan(basePackages = "com.ayris.rpctest")
@SpringBootApplication
public class RpcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcTestApplication.class, args);
    }

}
