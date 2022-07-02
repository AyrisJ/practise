package com.ayris.tkmybatis;

import cn.hutool.extra.spring.SpringUtil;
import com.ayris.tkmybatis.mapper.TOrderMapper;
import com.ayris.tkmybatis.service.TOrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.ayris.tkmybatis.mapper")
@RestController
public class TkmybatisApplication{

    public static void main(String[] args) {
        SpringApplication sa = new SpringApplication(TkmybatisApplication.class);
        // 2.6.0后默认不允许循环依赖，需要手动设置
        sa.setAllowCircularReferences(true);
        sa.run(args);
    }

    @RequestMapping("api/ok")
    public String ok() {
        return "ok";
    }

    @RequestMapping("api/test")
    public void test() {
        TOrderMapper orderMapper = SpringUtil.getBean(TOrderMapper.class);
        TOrderService orderService = SpringUtil.getBean(TOrderService.class);
    }
}
