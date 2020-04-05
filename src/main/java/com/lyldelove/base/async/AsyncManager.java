package com.lyldelove.base.async;

/**
 * @author lyldelove
 * @title AsyncManager 异步任务管理器
 * @date 2020/3/30 22:07
 */
public class AsyncManager {

    /**
     * 操作延迟10毫秒
     */
    private final int OPERATE_DELAY_TIME = 10;

    /**
     * 静态AsyncManager，单例
     */
    private static AsyncManager manager = new AsyncManager();

    /**
     * 无参构造函数
     */
    private AsyncManager(){}

    /**
     * 单例模式（饿汉式）
     * @return AsyncManager
     */
    public static AsyncManager getManager() {
        return manager;
    }

}
