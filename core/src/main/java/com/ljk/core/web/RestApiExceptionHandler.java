package com.ljk.core.web;

import com.ljk.core.exception.BusinessException;
import com.ljk.core.exception.FeignClientException;
import com.ljk.core.exception.ResourceNotFoundException;
import com.netflix.client.ClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * mvc异常统一处理
 * @author liujiankun
 * @date 2020/4/30 23:29
 */
@ControllerAdvice
public class RestApiExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestApiExceptionHandler.class);
    @Value("${debug:false}")
    private Boolean debug;

    public RestApiExceptionHandler() {
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInvalidRequestError(MethodArgumentNotValidException ex) {
        LOGGER.error("{}", ex);
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        StringBuffer msg = new StringBuffer();
        Iterator var4 = errorList.iterator();

        while(var4.hasNext()) {
            ObjectError error = (ObjectError)var4.next();
            msg.append(";").append(error.getDefaultMessage());
        }

        return new ErrorResponse(1001, msg.toString().replaceFirst(";", ""));
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInvalidRequestError(MethodArgumentTypeMismatchException ex) {
        LOGGER.error("{}", ex);
        return new ErrorResponse(1001, "参数类型异常");
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        LOGGER.error("{}", ex);
        return this.debug ? new ErrorResponse(1002, ex.toString()) : new ErrorResponse(1002, "输入的请求参数有误,请核实后重新输入");
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleHttpMessageNotReadableException(IllegalArgumentException ex) {
        LOGGER.error("{}", ex);
        return new ErrorResponse(1002, ex.getMessage());
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleBusinessException(BusinessException ex) {
        LOGGER.info("{}", ex);
        return new ErrorResponse(1003, ex.getMessage());
    }

    @ExceptionHandler({FeignClientException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleBusinessException(FeignClientException ex) {
        LOGGER.
                info("{}",ex);
        return new ErrorResponse(ex.getRemoteCode(), ex.getRemoteMessage());
    }

    @ExceptionHandler({ClientException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleRibbonClientException(FeignClientException ex) {
        LOGGER.info("{}", ex);
        return new ErrorResponse(ex.getRemoteCode(), ex.getRemoteMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex) {
        LOGGER.error("{}", ex);
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleUnexpectedServerError(Exception ex) {
        LOGGER.error("{}", ex);
        return new ErrorResponse(1000, ex.getMessage());
    }

    @ExceptionHandler({HttpServerErrorException.class})
    @ResponseBody
    public ErrorResponse handleHttpServerErrorException(HttpServerErrorException ex, HttpServletResponse response) {
        response.setStatus(ex.getStatusCode().value());
        LOGGER.error("{}", ex);
        LOGGER.error(ex.getResponseBodyAsString());
        return new ErrorResponse(ex.getStatusCode().value(), ex.getMessage());
    }

    @ExceptionHandler({MaxUploadSizeExceededException.class})
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ResponseBody
    public ErrorResponse handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex, HttpServletResponse response) {
        LOGGER.error("{}", ex);
        return new ErrorResponse(1000, "文件大小超过系统限制");
    }
}
