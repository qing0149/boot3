package com.jq.common.api.utils;

import cn.hutool.core.util.ObjectUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class RequestHolder {

    public static HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(ObjectUtil.isNotNull(requestAttributes)){
            return ((ServletRequestAttributes) Objects.requireNonNull(requestAttributes)).getRequest();
        }else{
            return null;
        }

    }
}
