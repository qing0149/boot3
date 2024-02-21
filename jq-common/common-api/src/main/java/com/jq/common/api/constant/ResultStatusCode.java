/**
 * teng.com
 * Copyright (c) 2019 All Rights Reserved.
 */
package com.jq.common.api.constant;


import lombok.Getter;

@Getter
public enum ResultStatusCode {
    Success(200, "Success"),
    TokenInvalidOrOverdueException(401, "登录令牌无效或过期"),
    InValidParameter(402, "无效的参数"),
    SystemException(403, "系统错误"),
    ServiceException(404, "服务端异常"),
    TypeMismatchException(405, "请求参数类型不匹配"),
    RequestMethodNotAllowed(406, "请求方法不可用"),
    WrongSignatureException(407, "签名异常"),
    MissAccessTokenException(408, "没有登录用户信息"),
    MissingServletRequestParameter(409, "缺少参数"),
    AuthorizationCodeError(410, "授权码错误"),
    ViolatingSecurityException(411, "您所访问的页面请求 提交的参数中有违反安全规则元素存在，拒绝访问!"),
    NoPermission(412, "没有权限！"),
    DataFormatException(413, "数据格式异常"),
    IllegalArgumentException(414, "非法参数"),
    SignatureTimeOut(415, "签名时间超过规定时间"),
    ACCOUNT_ENABLED_EXCEPTION(416, "账号已被禁用"),
    TOO_MANY_REQUESTS(417, "访问太频繁了")
    ;

    private final Integer code;
    private final String  message;

    private ResultStatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
