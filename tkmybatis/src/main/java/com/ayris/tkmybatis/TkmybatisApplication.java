package com.ayris.tkmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.ayris.tkmybatis.mapper")
public class TkmybatisApplication {

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(TkmybatisApplication.class);
        // 2.6.0后默认不允许循环依赖，需要手动设置
        sa.setAllowCircularReferences(true);
        sa.run(args);
    }

}
