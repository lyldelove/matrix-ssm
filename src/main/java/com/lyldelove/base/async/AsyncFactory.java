package com.lyldelove.base.async;

import com.lyldelove.base.util.IPUtil;
import com.lyldelove.base.util.ServletUtil;
import com.lyldelove.base.util.ShiroUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * @author lyldelove
 * @title AsyncFactory 产生任务的异步工厂
 * @date 2020/4/18 7:02
 */
public class AsyncFactory {

    private static final Logger sysUserLogger = LoggerFactory.getLogger("sys-user");

    /**
     * 保存登录的记录
     * @param username
     * @param status
     * @param message
     * @param args
     * @return
     */
    public static TimerTask saveLoginRecord(final String username, final String status, final String message, final Object... args) {
        //获取客户端浏览器信息
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtil.getRequest().getHeader("User-Agent"));
        String ip = ShiroUtil.getIp();

        return new TimerTask() {
            @Override
            public void run() {
                String address = IPUtil.getRealAddressByIP(ip);
            }
        };
    }
}
