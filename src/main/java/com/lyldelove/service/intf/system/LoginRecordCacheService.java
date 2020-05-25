package com.lyldelove.service.intf.system;

import java.util.concurrent.atomic.AtomicInteger;

public interface LoginRecordCacheService {

    /**
     * 往缓存中添加k-v
     * @param loginName
     * @param retryCount
     */
    void put(String loginName, AtomicInteger retryCount);

    /**
     * 根据k查询v
     * @param loginName
     */
    AtomicInteger get(String loginName);

    /**
     * 根据k删除v
     * @param loginName
     */
    void remove(String loginName);
}
