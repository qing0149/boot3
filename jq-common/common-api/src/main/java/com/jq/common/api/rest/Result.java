package com.jq.common.api.rest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Data
@EqualsAndHashCode(callSuper = false)
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final ResultCode SUCCESS = ResultCode.SUCCESS;

    public static final int TIPS = ResultCode.TIPS.getCode();

    public static final int FAIL = ResultCode.FAIL.getCode();

    private int code;

    /**
     * 错误/成功消息文本
     */
    private String msg;

    /**
     * 返回的数据对象
     */
    private T data;

    public static <T> Result<T> success() {
        return restResult(null, SUCCESS.getCode(), SUCCESS.getMsg());
    }

    public static <T> Result<T> success(String msg) {
        return restResult(null, SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> success(T data) {
        return restResult(data, SUCCESS.getCode(), null);
    }

    public static <T> Result<T> success(String dataStatus, T data) {
        return restResult(data, dataStatus, SUCCESS.getCode(), null);
    }

    public static <T> Result<T> success(T data, String msg) {
        return restResult(data, SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> tips(T data, String msg) {
        return restResult(data, TIPS, msg);
    }

    public static <T> Result<T> tips(T data, String dataStatus, String msg) {
        return restResult(data, dataStatus, TIPS, msg);
    }

    public static <T> Result<T> tips(String dataStatus, String msg) {
        return restResult(null, dataStatus, TIPS, msg);
    }

    public static <T> Result<T> tips(String msg) {
        return restResult(null, TIPS, msg);
    }

    public static <T> Result<T> fail() {
        return restResult(null, FAIL, null);
    }

    public static <T> Result<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }

    public static <T> Result<T> fail(T data) {
        return restResult(data, FAIL, null);
    }

    public static <T> Result<T> fail(T data, String msg) {
        return restResult(data, FAIL, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }


  /*  public static <T> Result<T> table(List<T> data, BaseRequest baseRequest) {
        Page<T> page = Page.newPage(baseRequest);
        page.setList(data);
        return (Result<T>) restResult(page, SUCCESS, "成功");
    }

    public static <T> Result<T> table(IPage page) {
        Page<T> page1 = Page.of(page);
        return (Result<T>) restResult(page1, SUCCESS, "成功");
    }

    public static <T> Result<T> table(Page page) {
        page.setList(page.getList());
        return (Result<T>) restResult(page, SUCCESS, "成功");
    }*/


    public static <T> Result<T> restResult(T data, String dataStatus, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

}