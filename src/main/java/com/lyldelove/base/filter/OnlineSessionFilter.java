package com.lyldelove.base.filter;

import com.lyldelove.base.shiro.OnlineSessionDAO;
import com.lyldelove.common.constant.ShiroConstant;
import com.lyldelove.common.util.ShiroUtil;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.dto.system.OnlineSession;
import com.lyldelove.entity.system.SysUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author lyldelove
 * @title OnlineSessionFilter 自定义在线用户处理过滤器
 * @date 2020/6/10 6:26
 */
public class OnlineSessionFilter extends AccessControlFilter {

    /**
     * 退出后重定向的地址
     */
    @Value("${shiro.user.loginUrl}")
    private String loginUrl;

    /**
     *
     */
    @Resource
    private OnlineSessionDAO onlineSessionDAO;

    /**
     * 是否通过验证
     * @param request 请求
     * @param response
     * @param mappedValue
     * @return 表示是否允许访问, 如果允许访问返回 true，否则 false
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);

        if (StringUtil.isNull(subject) || StringUtil.isNull(subject.getSession())) {
            return true;
        }

        Session session = onlineSessionDAO.readSession(subject.getSession().getId());

        if (session instanceof OnlineSession){
            OnlineSession onlineSession = (OnlineSession) session;
            request.setAttribute(ShiroConstant.ONLINE_SESSION, onlineSession);
            // 把user对象设置进去
            boolean isGuest = onlineSession.getUserId() == null || onlineSession.getUserId() == 0L;

            if (isGuest == true) {
                SysUser user = ShiroUtil.getSysUser();
                if (user != null)
                {
                    onlineSession.setUserId(user.getUserId());
                    onlineSession.setLoginName(user.getLoginName());
                    onlineSession.setAvatar(user.getAvatar());
                    onlineSession.setDeptName("");
                    onlineSession.markAttributeChanged();
                }
            }

            if (onlineSession.getStatus() == OnlineSession.OnlineStatus.off_line) {
                return false;
            }
        }
        return false;
    }

    /**
     * 没有通过验证时的操作
     * @param request
     * @param response
     * @return 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);

        if (StringUtil.isNotNull(subject)) {
            subject.logout();
        }

        saveRequestAndRedirectToLogin(request, response);

        return false;
    }

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        WebUtils.issueRedirect(request, response, loginUrl);
    }
}
