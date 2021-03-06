package com.lyldelove.base.async;

import com.lyldelove.common.spring.SpringContext;
import com.lyldelove.common.constant.BaseConstant;
import com.lyldelove.common.constant.LoginConstant;
import com.lyldelove.common.util.IPUtil;
import com.lyldelove.common.util.ServletUtil;
import com.lyldelove.common.util.ShiroUtil;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.dto.system.OnlineSession;
import com.lyldelove.entity.system.SysLoginLog;
import com.lyldelove.entity.system.SysUserOnline;
import com.lyldelove.service.intf.system.LoginLogService;
import com.lyldelove.service.intf.system.OnlineService;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.TimerTask;

/**
 * @author lyldelove
 * @title AsyncFactory 产生任务的异步工厂
 * @date 2020/4/18 7:02
 */
public class AsyncFactory {

    private static final Logger USER_LOG = LoggerFactory.getLogger("sys-user");

    /**
     * 保存登录的记录
     * @param username
     * @param status
     * @param message
     * @param args
     * @return
     */
    public static TimerTask saveLoginLog(final String username, final String status, final String message, final Object... args) {
        //获取客户端浏览器信息
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtil.getRequest().getHeader("User-Agent"));
        String ip = ShiroUtil.getIp();

        return new TimerTask() {
            @Override
            public void run() {
                String address = IPUtil.getRealAddressByIP(ip);
                //登录日志
                String logInfo = StringUtil.formatWithBlock(ip, address, username, status, message);
                USER_LOG.info(logInfo, args);
                //获取客户端操作系统
                String os= userAgent.getOperatingSystem().getName();
                //获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                //封装登录信息对象
                SysLoginLog loginLog = new SysLoginLog();
                loginLog.setLoginName(username);
                loginLog.setIpAddr(ip);
                loginLog.setLoginLocation(address);
                loginLog.setOs(os);
                loginLog.setBrowser(browser);
                loginLog.setMessage(message);
                loginLog.setStatus(LoginConstant.LOGIN_FAIL.equals(status) ? BaseConstant.FAIL : BaseConstant.SUCCESS);
                loginLog.setLoginTime(LocalDateTime.now());
                //存入数据库
                SpringContext.getBean(LoginLogService.class).saveLoginLog(loginLog);
            }
        };
    }

    public static TimerTask syncSessionToDb(OnlineSession onlineSession) {
        return new TimerTask() {
            @Override
            public void run() {
                SysUserOnline online =new SysUserOnline();

                online.setSessionId(onlineSession.getId() + "");
                online.setDeptName(onlineSession.getDeptName());
                online.setLoginName(onlineSession.getLoginName());
                online.setStartTimestamp(onlineSession.getStartTimestamp());
                online.setLastAccessTime(onlineSession.getLastAccessTime());
                online.setExpireTime(onlineSession.getTimeout());
                online.setIpAddr(onlineSession.getHost());
                online.setLoginLocation(IPUtil.getRealAddressByIP(onlineSession.getHost()));
                online.setBrowser(onlineSession.getBrowser());
                online.setOs(onlineSession.getOs());
                online.setStatus(onlineSession.getStatus());
                online.setSession(onlineSession);
                SpringContext.getBean(OnlineService.class).saveOnline(online);
            }
        };
    }
}
