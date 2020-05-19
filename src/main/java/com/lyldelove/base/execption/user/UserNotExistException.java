package com.lyldelove.base.execption.user;

import com.lyldelove.base.execption.constant.ExceptionCode;

/**
 * @author lyldelove
 * @title UserNotExistException 用户不存在异常
 * @date 2020/5/20 6:37
 */
public class UserNotExistException extends UserException {

    public UserNotExistException() {
        super(ExceptionCode.USER_NOT_EXIST, null);
    }
}
