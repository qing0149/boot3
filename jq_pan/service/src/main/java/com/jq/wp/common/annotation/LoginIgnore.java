package com.jq.wp.common.annotation;

import java.lang.annotation.*;

/**
 * @ClassName LoginIgnore
 * @Description 该注解主要影响那些不需要登录的接口该标注注解的方法会屏蔽统一的登录拦截校验逻辑
 * @Author
 * @Date 2024/3/9 8:36
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LoginIgnore {

}
