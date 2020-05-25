package com.lyldelove.service.impl.system;

import com.lyldelove.common.constant.ShiroConstant;
import com.lyldelove.service.intf.system.LoginRecordCacheService;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lyldelove
 * @title PasswordService 登录记录缓存
 * @date 2020/5/25 7:31
 */
@Service
public class LoginRecordCacheServiceImpl implements LoginRecordCacheService {

    @Autowired
    private CacheManager cacheManager;

    private Cache<String, AtomicInteger> loginRecordCache;

    @PostConstruct
    public void init() {
        loginRecordCache = cacheManager.getCache(ShiroConstant.LOGIN_RECORD_CACHE);
    }

    @Override
    public void put(String loginName, AtomicInteger retryCount) {
        loginRecordCache.put(loginName, retryCount);
    }

    @Override
    public AtomicInteger get(String loginName) {
        return loginRecordCache.get(loginName);
    }

    @Override
    public void remove(String loginName) {
        loginRecordCache.remove(loginName);
    }
}
