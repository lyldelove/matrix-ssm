package com.lyldelove.base.filter;

import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 验证码验证过滤器
 */
public class CaptchaValidateFilter extends AccessControlFilter {

    /**
     * 是否开启验证码
     */
    private boolean captchaEnabled = true;

    /**
     * 验证码类型
     */
    private String captchaType = "math";

    public void setCaptchaEnabled(boolean captchaEnabled) {
        this.captchaEnabled = captchaEnabled;
    }

    public void setCaptchaType(String captchaType) {
        this.captchaType = captchaType;
    }

    /**
     * 处理真正的拦截逻辑
     * @param request 请求
     * @param response 响应
     * @param mappedValue
     * @return
     * @throws Exception
     */
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return super.onPreHandle(request, response, mappedValue);
    }

    /**
     * 是否通过验证
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @param o
     * @return true 通过验证，false 没有通过验证
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //验证码禁用或者不是表单提交时，直接通过验证，允许访问
        if (!captchaEnabled || !"post".equals(httpServletRequest.getMethod().toLowerCase())) {
            return true;
        }

        String validateCode = httpServletRequest.getParameter(ShiroConstants.CURRENT_VALIDATECODE);

        return false;
    }

    /**
     * 没有通过验证时的操作
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
