package com.lyldelove.service.impl.system;

import com.lyldelove.base.async.AsyncFactory;
import com.lyldelove.base.async.AsyncManager;
import com.lyldelove.base.enums.UserStatus;
import com.lyldelove.base.execption.user.*;
import com.lyldelove.common.constant.LoginConstant;
import com.lyldelove.common.constant.ShiroConstant;
import com.lyldelove.common.util.MessageUtil;
import com.lyldelove.common.util.ServletUtil;
import com.lyldelove.common.util.ShiroUtil;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.LoginRecordCacheService;
import com.lyldelove.service.intf.system.LoginService;
import com.lyldelove.service.intf.system.PasswordService;
import com.lyldelove.service.intf.system.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lyldelove
 * @title LoginServiceImpl
 * @date 2020/3/23 23:23
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserService userService;

    @Resource
    private LoginRecordCacheService loginRecordCacheService;

    @Resource
    private PasswordService passwordService;

    @Value("${user.password.maxRetryCount}")
    private String maxRetryCount;

    @Override
    public SysUser login(String username, String password) {
        //判断验证码是否有异常
        if(!StringUtil.isEmpty(ServletUtil.getRequest().getAttribute(ShiroConstant.CAPTCHA_EXCEPTION))) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(username, LoginConstant.LOGIN_FAIL, MessageUtil.message(LoginConstant.USER_CAPTCHA_ERROR)));
            throw new CaptchaException();
        }
        //用户名或者密码为空
        if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(username, LoginConstant.LOGIN_FAIL, MessageUtil.message(LoginConstant.USER_LOGIN_PARAM_NULL)));
            throw new LoginParamNullException();
        }
        //查询用户信息
        SysUser sysUser = userService.selectUserByLoginName(username);

        //手机号登陆
        if(StringUtil.isNull(sysUser) && StringUtil.isMobilePhoneNumber(username)) {
            sysUser = userService.selectUserByMobilePhoneNumber(username);
        }
        //邮件地址登录
        if(StringUtil.isNull(sysUser) && StringUtil.isEmail(username)) {
            sysUser = userService.selectUserByEmail(username);
        }

        if(StringUtil.isNull(sysUser)) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(username, LoginConstant.LOGIN_FAIL, MessageUtil.message(LoginConstant.USER_NOT_EXIST)));
            throw new UserNotExistException();
        }

        if(UserStatus.DISABLE.getCode().equals(sysUser.getStatus())) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(username, LoginConstant.LOGIN_FAIL, MessageUtil.message(LoginConstant.USER_DISABLE)));
            throw new UserDisableException();
        }

        if (UserStatus.DELETE.getCode().equals(sysUser.getDeleteFlag())) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(username, LoginConstant.LOGIN_FAIL, MessageUtil.message(LoginConstant.USER_DELETE)));
            throw new UserDeleteException();
        }

        //缓存中查找密码错误次数
        String loginName = sysUser.getLoginName();
        AtomicInteger retryCount = loginRecordCacheService.get(loginName);

        if (StringUtil.isNull(retryCount)) {
            retryCount = new AtomicInteger(0);
            loginRecordCacheService.put(loginName, retryCount);
        }

        //等缓存自动到达最长空余时间失效后，才能重新登陆
        int maxRetry = Integer.valueOf(maxRetryCount);
        if (retryCount.incrementAndGet() > maxRetry) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(loginName, LoginConstant.LOGIN_FAIL, MessageUtil.message(LoginConstant.USER_PASSWORD_RETRY_LIMIT_EXCEED, maxRetry)));
            throw new UserPasswordRetryLimitExceedException(maxRetry);
        }

        //判断密码是否匹配
        if (!passwordService.matches(loginName, sysUser.getPassword(), sysUser.getSalt(), password)) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(loginName, LoginConstant.LOGIN_FAIL, MessageUtil.message(LoginConstant.USER_PASSWORD_NOT_MATCH)));
            //错误次数存入缓存
            loginRecordCacheService.put(loginName, retryCount);
            throw new UserPasswordNotMatchException();
        } else {
            loginRecordCacheService.remove(loginName);
        }

        //登录成功
        AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(loginName, LoginConstant.LOGIN_SUCCESS, MessageUtil.message(LoginConstant.USER_LOGIN_SUCCESS)));

        //更新用户登录信息
        sysUser.setLoginIp(ShiroUtil.getIp());
        sysUser.setLoginTime(LocalDateTime.now());
        userService.updateUserInfo(sysUser);

        return sysUser;
    }
}
