package com.ayris.eshighclient;

import com.alibaba.fastjson.JSONObject;
import com.ayris.eshighclient.constant.ElasticsearchConstant;
import com.ayris.eshighclient.model.Example;
import com.ayris.eshighclient.service.AbstractService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EshighclientApplicationTests {

    @Autowired
    @Qualifier("exampleServiceImpl")
    private AbstractService exampleService;

    @Test
    public void contextLoads() {

    }

    /**
     * 测试新增
     */
    @Test
    public void insertTest() {
        List<Example> list = new ArrayList<>();
        JSONObject object = new JSONObject();
        object.put("productName", "mashang");
        list.add(Example.builder().batchNum("001").entryParam(object).build());
        object = new JSONObject();
        object.put("productName", "yinlian");
        list.add(Example.builder().batchNum("002").entryParam(object).build());
        object = new JSONObject();
        object.put("productName", "zhongan");
        list.add(Example.builder().batchNum("003").entryParam(object).build());
        exampleService.insert(ElasticsearchConstant.INDEX_NAME, ElasticsearchConstant.TYPE_WORKFLOW, list);
    }

    /**
     * 测试更新
     */
    @Test
    public void updateTest() {
        JSONObject object = new JSONObject();
        object.put("productName", "mashang");
        object.put("loanAmount", 1000);
        Example example = Example.builder().batchNum("002").entryParam(object).build();
        List<Example> list = new ArrayList<>();
        list.add(example);
        exampleService.update(ElasticsearchConstant.INDEX_NAME, ElasticsearchConstant.TYPE_WORKFLOW, "AXsO0UDoMVjmu1Cv62So", list);
    }

    /**
     * 测试删除
     */
    @Test
    public void deleteTest() {
        exampleService.delete(ElasticsearchConstant.INDEX_NAME, ElasticsearchConstant.TYPE_WORKFLOW, "AXsO0UF7MVjmu1Cv62Sq", null);
    }

    /**
     * 测试查询
     */
    @Test
    public void searchTest() {
        exampleService.searchList(ElasticsearchConstant.INDEX_NAME, ElasticsearchConstant.TYPE_WORKFLOW);
    }


}
