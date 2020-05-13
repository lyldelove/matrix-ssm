package com.lyldelove.base.execption.user;

import com.lyldelove.base.execption.constant.ExceptionCode;

/**
 * @author lyldelove
 * @title LoginParamNullException 登录参数为空异常
 * @date 2020/5/14 6:26
 */
public class LoginParamNullException extends UserException {

    public LoginParamNullException() {
        super(ExceptionCode.USER_LOGIN_PARAM_NULL, null);
    }
}
