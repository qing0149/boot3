package com.jq.wp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-01-26 23:07
 **/
@SpringBootApplication(scanBasePackages = "com.jq")
@ServletComponentScan(basePackages = "com.jq")
@MapperScan("com.jq.wp.*.mapper")
@EnableTransactionManagement
public class WPApplication {
    public static void main(String[] args) {
        SpringApplication.run(WPApplication.class, args);
    }
}
