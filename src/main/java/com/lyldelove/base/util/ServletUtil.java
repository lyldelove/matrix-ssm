package com.lyldelove.base.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author lyldelove
 * @title ServletUtil Servlet工具类
 * @date 2020/4/17 7:02
 */
public class ServletUtil {

    public static ServletRequestAttributes getRequestAttributes()
    {
        //RequestContextHolder 持有上下文的Request容器
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }
}
