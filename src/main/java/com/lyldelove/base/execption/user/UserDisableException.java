package com.lyldelove.base.execption.user;

import com.lyldelove.base.execption.constant.ExceptionCode;

/**
 * @author lyldelove
 * @title UserDisableException 用户禁用异常
 * @date 2020/5/20 7:19
 */
public class UserDisableException extends UserException {

    public UserDisableException() {
        super(ExceptionCode.USER_DISABLE, null);
    }
}
