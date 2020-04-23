package com.lyldelove.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lyldelove
 * @title ServletUtil Servlet工具类
 * @date 2020/4/17 7:02
 */
public class ServletUtil {

    /**
     * 使用RequestContextHolder容器，从当前线程中取出请求相关的信息
     * @return
     */
    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 获取请求
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }
}
