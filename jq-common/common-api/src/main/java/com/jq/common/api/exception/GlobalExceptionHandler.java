/**
 * chengyun.com
 * Copyright (c) 2023 All Rights Reserved.
 */
package com.jq.common.api.exception;


import com.jq.common.api.constant.ResultStatusCode;
import com.jq.common.api.exception.model.AccessException;
import com.jq.common.api.exception.model.ServiceException;
import com.jq.common.api.rest.Result;
import com.jq.common.api.utils.ExceptionUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.List;
import java.util.zip.DataFormatException;


/**
 * 统一错误拦截处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * http请求的方法不正确
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        log.error("http请求的方法不正确:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.RequestMethodNotAllowed);
    }

    /**
     * 请求参数不全
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        log.error("请求参数不全:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.MissingServletRequestParameter);
    }

    /**
     * 请求参数类型不正确
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(TypeMismatchException.class)
    public Result typeMismatchExceptionHandler(TypeMismatchException e) {
        log.error("请求参数类型不正确:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.TypeMismatchException);
    }

    /**
     * 数据格式不正确
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(DataFormatException.class)
    public Result dataFormatExceptionHandler(DataFormatException e) {
        log.error("数据格式不正确:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.DataFormatException);
    }

    /**
     * 签名
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(AccessException.class)
    public Result accessExceptionHandler(AccessException e) {
        return ExceptionUtil.resultOf(e.getResultStatusCode());
    }

    /**
     * 非法输入
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(IllegalArgumentException.class)
    public Result illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("非法输入:【" + e.getMessage() + "】");
        return ExceptionUtil.resultOf(ResultStatusCode.IllegalArgumentException);
    }

    /**
     * 服务端异常
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ServiceException.class)
    public Result serviceExceptionHandler(ServiceException e) {
        log.error("服务端异常【" + e.getMessage() + "】");
        return Result.fail(ResultStatusCode.ServiceException.getCode(), e.getMessage());
    }

    /**
     * @Valited 参数检验失败
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result handlerMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        BindingResult br = ex.getBindingResult();
        StringBuilder msgStr = new StringBuilder();
        List<FieldError> feList = br.getFieldErrors();
        for (FieldError fe : feList) {
            String message = fe.getDefaultMessage();
            String field = fe.getField();
            msgStr.append(field).append(":").append(message).append("; ");
        }
        String message = msgStr.toString();
        log.error("参数检验错误信息:" + message);
        return Result.fail(ResultStatusCode.InValidParameter.getCode(), message);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler //处理其他异常
    public Result allExceptionHandler(Exception e) {
        log.error("具体错误信息:【" + ExceptionUtil.getErrorMessage(e) + "】"); //会记录出错的代码行等具体信息
        int count = 0; //只打印15行的错误堆栈
        e.getCause();
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            log.error(stackTraceElement.toString());
            if (count++ > 13)
                break;
        }

        return ExceptionUtil.resultOf(ResultStatusCode.SystemException);
    }

}
