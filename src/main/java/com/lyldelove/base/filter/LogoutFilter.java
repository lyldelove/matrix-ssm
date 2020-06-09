package com.lyldelove.base.filter;

import com.lyldelove.base.async.AsyncFactory;
import com.lyldelove.base.async.AsyncManager;
import com.lyldelove.common.constant.LoginConstant;
import com.lyldelove.common.constant.ShiroConstant;
import com.lyldelove.common.util.MessageUtil;
import com.lyldelove.common.util.ShiroUtil;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.entity.system.SysUser;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;

/**
 * @author lyldelove
 * @title LogoutFilter 登出过滤器
 * @date 2020/6/9 6:28
 */
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {

    private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);

    /**
     * 退出后重定向的地址
     */
    @Value("${shiro.user.loginUrl}")
    private String loginUrl;

    private Cache<String, Deque<Serializable>> cache;

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        try{
            Subject subject = getSubject(request, response);
            String redirectUrl = getRedirectUrl(request, response, subject);

            try {
                SysUser sysUser = ShiroUtil.getSysUser();

                if (StringUtil.isNotNull(sysUser)) {
                    String loginName = sysUser.getLoginName();
                    //记录用户退出日志
                    AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(loginName, LoginConstant.LOGOUT, MessageUtil.message(LoginConstant.USER_LOGOUT_SUCCESS)));
                    cache.remove(loginName);
                }
                //退出登录
                subject.logout();
            } catch (SessionException ex) {
                log.error("logout fail.", ex);
            }

            issueRedirect(request, response, redirectUrl);
        } catch (Exception ex) {
            log.error("Encountered session exception during logout. This can generally safely be ignored.", ex);
        }

        return false;
    }

    @Override
    protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {

        String loginUrl = getLoginUrl();

        if (StringUtil.isNotEmpty(loginUrl)) {
            return loginUrl;
        }

        return super.getRedirectUrl(request, response, subject);
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    // 设置Cache的key的前缀
    public void setCacheManager(CacheManager cacheManager)
    {
        // 必须和ehcache缓存配置中的缓存name一致
        this.cache = cacheManager.getCache(ShiroConstant.SYS_USERCACHE);
    }
}
