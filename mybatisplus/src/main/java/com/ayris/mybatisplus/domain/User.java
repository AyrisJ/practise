package com.ayris.mybatisplus.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private String label;

    private static final long serialVersionUID = 1L;
}