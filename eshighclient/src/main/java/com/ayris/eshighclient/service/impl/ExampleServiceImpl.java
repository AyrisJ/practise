package com.ayris.eshighclient.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ayris.eshighclient.model.Example;
import com.ayris.eshighclient.service.AbstractService;
import com.ayris.eshighclient.service.BaseElasticsearchService;
import org.apache.lucene.search.BooleanQuery;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.query.QuerySearchRequest;
import org.elasticsearch.transport.TransportRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ExampleServiceImpl extends BaseElasticsearchService implements AbstractService<Example> {

    @Override
    public void insert(String index, String type, List<Example> list) {
        try {
            list.forEach(item -> {
                IndexRequest request = buildIndexRequest(index, type, item.getId(), item);
                try {
                    IndexResponse indexResponse = client.index(request);
                    System.out.println(indexResponse);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(String index, String type, String id, List<Example> list) {
        list.forEach(item -> {
            updateRequest(index, type, id, item);
        });
    }

    @Override
    public void delete(String index, String type, String id, Example example) {
//        if (ObjectUtils.isEmpty(example)) {
//            // 如果person 对象为空，则删除全量
//            searchList(index, type).forEach(p -> {
//                deleteRequest(index, type, p.getId());
//            });
//        }
        deleteRequest(index, type, id);
    }

    @Override
    public List<Example> searchList(String index, String type) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.query(QueryBuilders.termQuery("batchNum", "002"));
        searchSourceBuilder.query(QueryBuilders.termQuery("entryParam.productName", "yinlian"));
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10);

        SearchResponse searchResponse = search(index, type, searchSourceBuilder);
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Example> examples = new ArrayList<>();
        Arrays.stream(hits).forEach(hit -> {
            Map<String, Object> sourceAsMap = hit.getSource();
            Example example = BeanUtil.mapToBean(sourceAsMap, Example.class, true);
            examples.add(example);
            System.out.println(example);
        });
        ;
        return examples;
    }

}
