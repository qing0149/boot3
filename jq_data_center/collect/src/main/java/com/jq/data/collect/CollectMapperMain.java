package com.jq.data.collect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jq.data.collect.infra.repository.mapper")
public class CollectMapperMain {
    public static void main(String[] args) {
        SpringApplication.run(CollectMapperMain.class);
    }
}
