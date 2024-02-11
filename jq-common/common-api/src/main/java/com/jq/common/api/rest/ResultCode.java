package com.jq.common.api.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-11 16:24
 **/
@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(200, "成功"),
    TIPS(250, "成功"),
    FAIL(500, "失败"),
    ;
    private final Integer code;
    private final String msg;
    private static final HashMap<Integer, ResultCode> map;

    static {
        HashMap<Integer, ResultCode> hashMap = new HashMap<>(ResultCode.values().length);
        for (ResultCode value : ResultCode.values()) {
            hashMap.put(value.code, value);
        }
        map = hashMap;
    }
}
