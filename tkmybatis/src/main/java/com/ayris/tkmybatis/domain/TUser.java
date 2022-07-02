package com.ayris.tkmybatis.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_user")
@Getter
@Setter
public class TUser {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private Integer age;

    private String job;

    private String remark;
}
