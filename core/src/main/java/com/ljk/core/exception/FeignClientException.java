package com.ljk.core.exception;

/**
 * @author liujiankun
 * @date 2020/5/1 0:00
 */
public class FeignClientException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String module = "MICRO_SERVICE";
    private String business;
    private String errorCode;
    private String remoteMessage;
    private int remoteCode;

    public FeignClientException(String serviceName, String errorMessage) {
        super(errorMessage);
        this.business = serviceName;
        this.errorCode = "REST_ERROR";
    }

    public FeignClientException(String errorMessage) {
        super(errorMessage);
        this.business = "";
        this.errorCode = "REST_ERROR";
    }

    @Override
    public String toString() {
        return this.module + "-" + this.business + "-" + this.errorCode + ":" + this.getMessage();
    }

    public String getModule() {
        return this.module;
    }

    public String getBusiness() {
        return this.business;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getRemoteMessage() {
        return this.remoteMessage;
    }

    public int getRemoteCode() {
        return this.remoteCode;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setRemoteMessage(String remoteMessage) {
        this.remoteMessage = remoteMessage;
    }

    public void setRemoteCode(int remoteCode) {
        this.remoteCode = remoteCode;
    }
}
