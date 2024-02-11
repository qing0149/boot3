package com.jq.cache.redis.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @program: Boot3
 * @description:redis的普通操作Utils
 *
 * @author:
 * @create: 2024-02-11 16:49
 **/
public class RedisUtils {
    private static StringRedisTemplate stringRedisTemplate;

    private static RedisTemplate<String, Object> redisTemplate;
}
