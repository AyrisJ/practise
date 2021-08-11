package com.ayris.eshighclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Example implements Serializable {

    private String id;
    private String batchNum;
    private String label;
    private boolean isSame;
    private String productName;
    private Map<String,Object> entryParam;
    private Map<String,Object> expectResult;
    private Map<String,Object> outputParam;

}
