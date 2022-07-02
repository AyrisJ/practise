package com.ayris.tkmybatis.base;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private Integer code;

    private String msg;

    private boolean success;

    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setSuccess(true);
        response.setMsg("ok");
        response.setData(data);
        return response;
    }

}
