package com.lld.im.common;


import lombok.Data;

@Data
public class ResponseVO<T> {

    private int code;

    private String msg;

    private T data;
}
