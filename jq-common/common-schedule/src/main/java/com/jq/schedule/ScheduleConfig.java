package com.jq.schedule;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-02-22 14:48
 **/
@SpringBootConfiguration
public class ScheduleConfig {
    @Bean
    public ThreadPoolTaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        return taskScheduler;
    }
}
