package com.lyldelove.base.shiro;

import com.lyldelove.base.execption.user.*;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

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

        if(StringUtil.isNotNull(token.getPassword())) {
            password = new String(token.getPassword());
        }

        SysUser sysUser = null;

        try {
            sysUser = loginService.login(username, password);
        } catch (CaptchaException e) {
            throw new AuthenticationException(e.getMessage(), e);
        } catch (LoginParamNullException | UserNotExistException | UserDeleteException e) {
            throw new UnknownAccountException(e.getMessage(), e);
        } catch (UserDisableException e) {
            throw new LockedAccountException(e.getMessage(), e);
        } catch (UserPasswordRetryLimitExceedException e) {
            throw new ExcessiveAttemptsException(e.getMessage(), e);
        } catch (UserPasswordNotMatchException e) {
            throw new IncorrectCredentialsException(e.getMessage(), e);
        } catch (Exception e) {
            log.info("对用户{}进行登录验证..验证未通过{}", username, e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }

        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(sysUser, password, getName());
    }
}
