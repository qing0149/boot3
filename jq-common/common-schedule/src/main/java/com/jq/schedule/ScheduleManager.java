package com.jq.schedule;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.jq.common.api.exception.model.ServiceException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @program: Boot3
 * @description: 1.创建并启动一个定时任务
 * 2.停止一个定时任务
 * 3.更新一个定时任务
 * @author:
 * @create: 2024-02-22 14:57
 **/
@Component
@Slf4j
public class ScheduleManager {
    @Resource
    private ThreadPoolTaskScheduler taskScheduler;
    /**
     * 内部正在执行的定时任务缓存
     */
    private Map<String, ScheduleTaskHolder> cache = new ConcurrentHashMap<>();
//    private ThreadLocal<Map> threadLocal;

    /**
     * 启动一个定时任务
     *
     * @param scheduleTask 定时任务实现类
     * @param cron         定时任务表达式
     * @return
     */
    public String startTask(ScheduleTask scheduleTask, String cron) {
        ScheduledFuture<?> scheduledFuture = taskScheduler.schedule(scheduleTask, new CronTrigger(cron));
        String key = StrUtil.uuid();
        ScheduleTaskHolder holder = new ScheduleTaskHolder();
        holder.setScheduleTask(scheduleTask);
        holder.setScheduledFuture(scheduledFuture);
        cache.put(key, holder);
        log.info("{}启动成功!唯一标识为:{}", scheduleTask.getName(), key);
        return key;
    }

    public void stopTask(String key) {
        if (StrUtil.isBlank(key)) {
            return;
        }
        ScheduleTaskHolder holder = cache.get(key);
        if (ObjectUtil.isNull(holder)) {
            return;
        }
        String name = holder.getScheduleTask().getName();
        ScheduledFuture scheduledFuture = holder.getScheduledFuture();
        boolean cancel = scheduledFuture.cancel(true);
        if (cancel) {
            log.info("{}停止成功!唯一标识为:{}", name, key);
        } else {
            log.error("{}停止失败!唯一标识为:{}", name, key);
        }
    }

    /**
     * 更新一个定时任务的执行时间
     *
     * @param key  定时任务的唯一标识
     * @param cron 新的cron表达式
     * @return
     * @throws ServiceException
     */
    public String changeTask(String key, String cron) throws ServiceException {
        if (StrUtil.isAllBlank(key, cron)) {
            throw new ServiceException("定时任务的唯一标识以及新的执行表达式不能为空");

        }
        ScheduleTaskHolder holder = cache.get(key);
        if (ObjectUtil.isNull(holder)) {
            throw new ServiceException(key + "唯一标识不存在");
        }
        stopTask(key);
        return startTask(holder.getScheduleTask(), cron);

    }
}
