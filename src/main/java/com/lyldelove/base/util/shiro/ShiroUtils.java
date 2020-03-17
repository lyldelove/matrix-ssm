package com.lyldelove.base.util.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class ShiroUtils {

    /**
     * 获取Shiro Session
     * @return Session
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }
}
