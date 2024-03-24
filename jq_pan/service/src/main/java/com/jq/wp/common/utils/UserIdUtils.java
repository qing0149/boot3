package com.jq.wp.common.utils;

import cn.hutool.core.util.ObjectUtil;
import com.jq.common.api.exception.model.ServiceException;

/**
 * @program: Boot3
 * @description:用户Id存储工具类
 * @author:
 * @create: 2024-03-08 22:53
 **/
public class UserIdUtils {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程的用户Id
     *
     * @param userId
     */
    public static void set(Long userId) {
        threadLocal.set(userId);
    }

    /**
     * 获取当前线程的用户ID
     */
    public static Long get() throws ServiceException {
        Long userId = threadLocal.get();
        if (ObjectUtil.isNull(userId)) {
            throw new ServiceException("用户登录异常");
        }
        return userId;
    }
}
