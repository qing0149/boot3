package com.jq.common.controller;

import cn.hutool.core.util.StrUtil;
import com.jq.common.api.exception.ServiceException;
import com.jq.common.api.utils.RequestHolder;
import com.jq.common.model.JwtSysUser;
import com.jq.common.model.UserBean;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-06 11:27
 **/
@Slf4j
public class BaseController {

    private Integer type = 0;

    /**
     * 取当前登录用户的用户ID
     *
     * @return
     * @throws ServiceException
     */
    protected Long getCurrentUserId() throws ServiceException {
        String token = RequestHolder.getHttpServletRequest().getHeader("Token");
        type = 0;
        if (StrUtil.isEmpty(token)) {
            token = RequestHolder.getHttpServletRequest().getHeader("Client-Token");
            type = 1;
        }
//        String tokenKey = String.format(RedisConstant.SYS_USER_TOKEN_KEY, token);
//        String userId = RedisUtils.get(tokenKey);
//        if (StrUtil.isEmpty(userId)) {
//            log.error("令牌无效或过期");
//            throw new ServiceException(ResultStatusCode.TokenInvalidOrOverdueException);
//        }
//        return Long.valueOf(userId);
        return null;
    }

    /**
     * 取当前登录用户的用户信息 UserBean
     *
     * @return
     * @throws ServiceException
     */
    protected UserBean getCurrentUser() throws ServiceException {
        Long userId = this.getCurrentUserId();
        JwtSysUser jwtSysUser = null;
        String loginKey;
        if (0 == type) {
            log.debug("后台登录用户：{}", type);
//            loginKey = String.format(RedisConstant.SYS_USER_LOGIN_KEY, userId);
        } else {
            log.debug("后台登录用户：{}", type);
//            loginKey = String.format(RedisConstant.LOGIN_USER_INFO_KEY, userId);
        }
//        jwtSysUser = RedisUtils.get2(loginKey, JwtSysUser.class);
        if (null == jwtSysUser || null == jwtSysUser.getUser()) {
            log.error("令牌无效或过期");
//            throw new ServiceException(ResultStatusCode.TokenInvalidOrOverdueException);
        }
        return jwtSysUser.getUser();
    }

}
