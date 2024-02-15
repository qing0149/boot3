/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.jq.common.config;

import cn.hutool.core.util.RandomUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * swagger的配置
 */
@Configuration
public class SwaggerConfig {

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.termsOfService}")
    private String termsOfService;

    @Value("${swagger.url}")
    private String url;


    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getTags() != null) {
                openApi.getTags().forEach(tag -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("x-order", RandomUtil.randomInt(0, 100));
                    tag.setExtensions(map);
                });
            }
            if (openApi.getPaths() != null) {
                openApi.addExtension("x-test123", "333");
                openApi.getPaths().addExtension("x-abb", RandomUtil.randomInt(1, 100));
            }

        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(Optional.ofNullable(title).orElse("XXX用户系统API"))
                        .version(Optional.ofNullable(version).orElse("1.0"))
                        .description(Optional.ofNullable(description).orElse("Knife4j集成springdoc-openapi示例"))
                        .termsOfService(Optional.ofNullable(termsOfService).orElse("Knife4j集成springdoc-openapi示例"))
                        .license(new License().name("Apache 2.0")
                                .url(Optional.ofNullable(url).orElse("url"))));
    }
}
