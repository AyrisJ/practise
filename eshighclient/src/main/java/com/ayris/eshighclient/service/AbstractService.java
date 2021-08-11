package com.ayris.eshighclient.service;

import org.springframework.lang.Nullable;

import java.util.List;


public interface AbstractService<T> {


    void insert(String index, String type, List<T> list);

    /**
     * update document source
     *
     * @param index elasticsearch index name
     * @param list  data source
     * @author fxbin
     */
    void update(String index, String type,String id, List<T> list);

    /**
     * delete document source
     *
     * @param t delete data source and allow null object
     * @author fxbin
     */
    void delete(String index, String type,String id, @Nullable T t);

    /**
     * search all doc records
     *
     * @param index elasticsearch index name
     * @return person list
     * @author fxbin
     */
    List<T> searchList(String index, String type);

}
