package com.ayris.tkmybatis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @TableName t_order
 */
@Table(name="t_order")
@Data
@NoArgsConstructor
public class TOrder implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     *
     */
    private String ai;

    /**
     *
     */
    private String bi;

    /**
     *
     */
    private String ci;

    private String remark;

    private static final long serialVersionUID = 1L;

}