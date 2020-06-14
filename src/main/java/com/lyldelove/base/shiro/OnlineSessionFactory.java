package com.lyldelove.base.shiro;

import com.lyldelove.common.util.IPUtil;
import com.lyldelove.common.util.ServletUtil;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.dto.system.OnlineSession;
import com.lyldelove.entity.system.SysUserOnline;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lyldelove
 * @title OnlineSessionFactory
 * @date 2020/6/10 7:14
 */

public class OnlineSessionFactory implements SessionFactory {

    @Override
    public Session createSession(SessionContext initData) {
        OnlineSession session = new OnlineSession();

        if (initData instanceof WebSessionContext) {
            WebSessionContext sessionContext = (WebSessionContext) initData;
            HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();

            if (StringUtil.isNotNull(request)) {
                UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtil.getRequest().getHeader("User-Agent"));
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                session.setHost(IPUtil.getIpAddr(request));
                session.setBrowser(browser);
                session.setOs(os);
            }
        }
        return session;
    }

    public Session createSession(SysUserOnline sysUserOnline) {

        OnlineSession onlineSession = sysUserOnline.getSession();

        if (StringUtil.isNotNull(onlineSession) && StringUtil.isNull(onlineSession.getId())) {
            onlineSession.setId(sysUserOnline.getSessionId());
        }

        return sysUserOnline.getSession();
    }
}
