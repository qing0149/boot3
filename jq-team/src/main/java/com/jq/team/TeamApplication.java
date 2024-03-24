package com.jq.team;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-03 18:06
 **/
@SpringBootApplication(scanBasePackages = "com.jq")
@ServletComponentScan(basePackages = "com.jq")
@MapperScan("com.jq.*.mapper")
@EnableTransactionManagement
public class TeamApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeamApplication.class, args);
    }
}
