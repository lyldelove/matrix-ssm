package com.lyldelove.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author lyldelove
 * @title ThreadUtil 线程工具类
 * @date 2020/4/14 6:55
 */
public class ThreadUtil {

    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(ThreadUtil.class);

    /**
     * 打印线程异常信息
     * @param r Runnable
     * @param t Throwable
     */
    public static void printException(Runnable r, Throwable t) {
        //线程任务正常结束，判断线程结束的原因，捕捉异常并记录log
        if (t == null && r instanceof Future<?>) {
            try {
                Future<?> future = (Future<?>) r;
                if (future.isDone()) {
                    future.get();
                }
            }
            catch (CancellationException ce) {
                t = ce;
            }
            catch (ExecutionException ee) {
                t = ee.getCause();
            }
            catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        if (t != null) {
            logger.error(t.getMessage(), t);
        }
    }
}
