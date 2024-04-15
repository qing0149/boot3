package com.jq.admin;

import com.jq.admin.config.MqConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-02 15:06
 **/
@SpringBootApplication(scanBasePackages = "com.jq")
@ServletComponentScan(basePackages = "com.jq")
@MapperScan("com.jq.*.mapper")
@EnableTransactionManagement
@EnableConfigurationProperties(MqConst.class)
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
    //一些修改
    //一些修改
    //一些修改
    //一些修改
    //一些修改
    //一些修改
    //一些修改
    //一些修改
    //一些修改
}
