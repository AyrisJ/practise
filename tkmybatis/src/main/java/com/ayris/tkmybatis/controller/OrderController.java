package com.ayris.tkmybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.ayris.tkmybatis.base.Page;
import com.ayris.tkmybatis.domain.TOrder;
import com.ayris.tkmybatis.service.TOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private TOrderService orderService;

    @PostMapping("insert/batch")
    public void insertBatch() {
        List<TOrder> list = new ArrayList<>(150);

        for (int i = 0; i <= 100; i++) {
            TOrder order = new TOrder();
            JSONObject object = new JSONObject();
            object.put("ai", i);
            order.setAi(object.toJSONString());
            object.put("bi", i);
            order.setBi(object.toJSONString());
            object.put("ci", i);
            order.setCi(object.toJSONString());
            order.setRemark("rk");
            list.add(order);

            if (list.size() % 100 == 0) {
                orderService.saveList(list);
                list.clear();
            }

        }
        orderService.saveList(list);
    }

    @GetMapping("query")
    public void query() {
        Example example = new Example(TOrder.class);
        example.or().andCondition("JSON_EXTRACT(ci,'$.ci')=300000");
        example.or().andCondition("JSON_EXTRACT(bi,'$.bi')=200000");
        example.or().andCondition("JSON_EXTRACT(ai,'$.ai')=100000");

        List<TOrder> orderList = orderService.selectByExample(example);
        for (TOrder order : orderList) {
            System.out.println(order);
        }
    }

    @GetMapping("page")
    public void page() {
        Example example = new Example(TOrder.class);
//        example.or().andCondition("JSON_EXTRACT(ci,'$.ci')>=300000");

        Page<TOrder> page = orderService.selectPageByExample(example, 1, 10, "id");
        List<TOrder> orderList = page.getContents();
         for (TOrder order : orderList) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        String ss = "abbmodejjj";

        String bb = ss.replace("mode", "'mode'");
        System.out.println(bb);

    }

}
