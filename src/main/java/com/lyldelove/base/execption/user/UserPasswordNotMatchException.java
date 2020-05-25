package com.lyldelove.base.execption.user;

import com.lyldelove.base.execption.constant.ExceptionCode;

/**
 * @author lyldelove
 * @title UserPasswordNotMatchException 用户密码不匹配异常
 * @date 2020/5/26 6:21
 */
public class UserPasswordNotMatchException extends UserException {

    public UserPasswordNotMatchException() {
        super(ExceptionCode.USER_PASSWORD_NOT_MATCH, null);
    }
}
