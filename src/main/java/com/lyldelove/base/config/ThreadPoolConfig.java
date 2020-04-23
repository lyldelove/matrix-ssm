package com.lyldelove.base.config;

import com.lyldelove.common.util.ThreadUtil;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lyldelove
 * @title ThreadPoolConfig 线程池配置类
 * @date 2020/4/14 6:36
 */
@Configuration
public class ThreadPoolConfig {
    // 核心线程池大小
    private int corePoolSize = 50;

    // 最大可创建的线程数
    private int maxPoolSize = 200;

    // 队列最大长度
    private int queueCapacity = 1000;

    // 线程池维护线程所允许的空闲时间
    private int keepAliveSeconds = 300;

    /**
     * 线程池
     * @return ThreadPoolTaskExecutor
     */
    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(maxPoolSize);
        executor.setCorePoolSize(corePoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 线程池对拒绝任务(无线程可用)的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    /**
     * 执行周期性或定时任务
     * @return ScheduledExecutorService
     */
    @Bean(name = "scheduledExecutorService")
    protected ScheduledExecutorService scheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(corePoolSize,
                new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build())
        {
            //线程完成时的回调
            @Override
            protected void afterExecute(Runnable r, Throwable t)
            {
                super.afterExecute(r, t);
                ThreadUtil.printException(r, t);
            }
        };
    }
}
