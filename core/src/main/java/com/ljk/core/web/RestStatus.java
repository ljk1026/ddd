package com.ljk.core.web;

/**
 * @author liujiankun
 * @date 2020/4/30 22:45
 */
public enum RestStatus {
    SUCCESS(0),
    ERROR(500, "系统异常"),
    UNAUTHORIZED(401, "未授权访问"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "内容不存在"),
    SERVER_ERROR(500, "服务器异常");

   private Integer code;
    private String msg;

    private RestStatus(Integer code) {
        this.code = code;
        switch(code) {
            case -1:
                this.msg = "系统繁忙，请稍后再试";
                break;
            case 0:
                this.msg = "执行成功";
                break;
            default:
                this.msg = "系统未定义";
        }

    }

    private RestStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
