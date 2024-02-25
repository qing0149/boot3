package com.jq.schedule;

/**
 * @ClassName ScheduleTask
 * @Description 定时任务的任务接口
 * @Author
 * @Date 2024/2/22 14:55
 * @Version 1.0
 */
public interface ScheduleTask extends Runnable{
    /**
     * 获取定时任务的名称
     * @return
     */
    String getName();
}
