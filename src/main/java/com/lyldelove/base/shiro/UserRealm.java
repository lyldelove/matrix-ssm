package com.lyldelove.base.shiro;

import com.lyldelove.base.util.string.StringUtils;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 根据Token获取认证信息, 进行登录认证
     * @param authenticationToken token
     * @return 认证信息
     * @throws AuthenticationException 身份验证失败异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = "";

        if(StringUtils.isNotNull(token.getPassword())) {
            password = new String(token.getPassword());
        }

        SysUser sysUser = null;

        sysUser = loginService.login(username, password);


        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
