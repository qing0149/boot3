package com.jq.wp.user.constants;

/**
 * @program: Boot3
 * @description: 用户模块的常量类
 * @author:
 * @create: 2024-03-04 22:38
 **/
public interface UserConstants {
    /**
     * 登录用户的用户Id的key
     */
    String LOGIN_USER_ID = "LOGIN_USER_ID";
    /**
     * 一天的毫秒
     */
    Long ONE_DAY_LONG = 24*60*60*1000L;
    /**
     * 用户登录缓存前缀
     */
    String USER_LOGIN_PREFIX = "USER_LOGIN_";
}
