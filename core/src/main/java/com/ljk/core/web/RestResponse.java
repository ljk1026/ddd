package com.ljk.core.web;

/**
 * @author liujiankun
 * @date 2020/4/30 22:43
 */
public class RestResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public RestResponse() {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == 0 || this.code.equals(200);
    }
}
