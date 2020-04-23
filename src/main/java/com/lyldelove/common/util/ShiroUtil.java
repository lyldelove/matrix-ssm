package com.lyldelove.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    /**
     * 获取Shiro Subject
     * @return Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取Shiro Session
     * @return Session
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /**
     * 获取Shiro Session中的Host
     * @return IP
     */
    public static String getIp() {
        return getSession().getHost();
    }
}
