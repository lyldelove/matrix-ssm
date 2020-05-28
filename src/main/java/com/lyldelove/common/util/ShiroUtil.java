package com.lyldelove.common.util;

import com.lyldelove.entity.system.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;

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

    /**
     * 获取系统用户
     * @return
     */
    public static SysUser getSysUser() {
        SysUser sysUser = null;
        Object object = getSubject().getPrincipal();

        if (StringUtil.isNotNull(object)) {
            sysUser = new SysUser();
            BeanUtil.copyBeanProp(sysUser, object);
        }

        return sysUser;
    }

    /**
     * 设置系统用户
     * @param sysUser
     */
    public static void setSysUser(SysUser sysUser) {
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPreviousPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        SimplePrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(sysUser, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }
}
