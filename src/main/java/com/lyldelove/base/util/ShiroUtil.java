package com.lyldelove.base.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class ShiroUtil {

    /**
     * 获取Shiro Session
     * @return Session
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }
}
