package com.lyldelove.service.impl.system;

import com.lyldelove.base.async.AsyncFactory;
import com.lyldelove.base.async.AsyncManager;
import com.lyldelove.base.execption.constant.ExceptionCode;
import com.lyldelove.base.execption.user.CaptchaException;
import com.lyldelove.base.execption.user.LoginParamNullException;
import com.lyldelove.common.constant.LoginConstant;
import com.lyldelove.common.constant.ShiroConstant;
import com.lyldelove.common.util.MessageUtil;
import com.lyldelove.common.util.ServletUtil;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author lyldelove
 * @title LoginServiceImpl
 * @date 2020/3/23 23:23
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public SysUser login(String username, String password) {
        //判断验证码是否有异常
        if(!StringUtil.isEmpty(ServletUtil.getRequest().getAttribute(ShiroConstant.CAPTCHA_EXCEPTION))) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(username, LoginConstant.LOGIN_FAIL, MessageUtil.message(ExceptionCode.USER_CAPTCHA_ERROR)));
            throw new CaptchaException();
        }
        //用户名或者密码为空
        if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginLog(username, LoginConstant.LOGIN_FAIL, MessageUtil.message(ExceptionCode.USER_LOGIN_PARAM_NULL)));
            throw new LoginParamNullException();
        }
        //查询用户信息
        //SysUser sysUser =

        return null;
    }
}
