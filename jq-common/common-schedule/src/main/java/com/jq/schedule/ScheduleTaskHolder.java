package com.jq.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.concurrent.ScheduledFuture;

/**
 * @program: Boot3
 * @description: 定时任务和定时任务结束的缓存对象
 * @author:
 * @create: 2024-02-22 15:35
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleTaskHolder implements Serializable {

    /**
     * 执行任务实体
     */
    private ScheduleTask scheduleTask;

    /**
     * 执行任务结果实体
     */
    private ScheduledFuture scheduledFuture;

}
