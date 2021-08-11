package com.ayris.tkmybatis.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    /**
     * 总记录数
     */
    private long total;
    /**
     * 当前页
     */
    private int curPage;
    /**w
     * 每页的数量
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 当前页的数量
     */
    private int size;
    /**
     * 内容列表
     */
    private List<T> contents;

}
