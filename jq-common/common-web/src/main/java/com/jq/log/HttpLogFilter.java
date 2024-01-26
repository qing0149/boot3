package com.jq.log;

import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 打印HTTP调用日志过滤器，使用者可以按需将其注入到过滤器容器中使用
 * 这里只提供基础的过滤实现
 */
@WebFilter(filterName = "httpLogFilter")
@Slf4j

@Order()
public class HttpLogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        StopWatch stopWatch = StopWatch.createStarted();
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        filterChain.doFilter(requestWrapper, responseWrapper);
        HttpLogEntity httpLogEntity = HttpLogEntityBuilder.build(requestWrapper, responseWrapper, stopWatch);
        httpLogEntity.print();
        responseWrapper.copyBodyToResponse();
    }

}