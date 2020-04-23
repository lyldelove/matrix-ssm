package com.lyldelove.base.filter;

import com.google.code.kaptcha.Constants;
import com.lyldelove.common.util.ShiroUtil;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.common.constant.ShiroConstant;
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
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @param mappedValue [urls]配置中拦截器参数部分
     * @return true 继续处理, false 直接返回
     * @throws Exception 异常
     */
    @Override
    public boolean onPreHandle(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        servletRequest.setAttribute(ShiroConstant.CAPTCHA_ENABLED, captchaEnabled);
        servletRequest.setAttribute(ShiroConstant.CAPTCHA_TYPE, captchaType);
        return super.onPreHandle(servletRequest, servletResponse, mappedValue);
    }

    /**
     * 是否通过验证
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @param mappedValue [urls]配置中拦截器参数部分
     * @return 表示是否允许访问, 如果允许访问返回 true，否则 false
     * @throws Exception 异常
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //验证码禁用或者不是表单提交时，直接通过验证，允许访问
        if (!captchaEnabled || !"post".equals(httpServletRequest.getMethod().toLowerCase())) {
            return true;
        }
        //获取输入的验证码
        String validateCode = httpServletRequest.getParameter(ShiroConstant.CAPTCHA_CODE);
        //获取KAPTCHA生成的key
        Object object = ShiroUtil.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String code = StringUtil.isNull(object) ? "" : object.toString();

        //进行比较校验
        if (StringUtil.isEmpty(validateCode) || !validateCode.equalsIgnoreCase(code))
        {
            return false;
        }

        return true;
    }

    /**
     * 没有通过验证时的操作
     * @param servletRequest 请求
     * @param servletResponse 响应
     * @return 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可
     * @throws Exception 异常
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        servletRequest.setAttribute(ShiroConstant.CAPTCHA_EXCEPTION, ShiroConstant.CAPTCHA_ERROR);
        return true;
    }
}
