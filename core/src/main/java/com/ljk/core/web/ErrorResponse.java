package com.ljk.core.web;

/**
 * @author liujiankun
 * @date 2020/4/30 23:30
 */
public class ErrorResponse extends RestResponse{
    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }
}
