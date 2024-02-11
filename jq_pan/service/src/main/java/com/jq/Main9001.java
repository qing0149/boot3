package com.jq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-01-26 23:07
 **/
@SpringBootApplication(scanBasePackages = "com.jq")
@ServletComponentScan(basePackages = "com.jq")
@RestController
public class Main9001 {
    public static void main(String[] args) {
        SpringApplication.run(Main9001.class, args);
    }
}
