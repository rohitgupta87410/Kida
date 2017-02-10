package com.espark.adarsh.bean;

import java.io.Serializable;

public class ResponseBean<T> implements Serializable{

    private T data;
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
