package com.ljk.core.exception;

/**
 * @author liujiankun
 * @date 2020/4/30 23:52
 */
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private static final String MSG = "数据不存在";

    public ResourceNotFoundException() {
        super("数据不存在");
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
