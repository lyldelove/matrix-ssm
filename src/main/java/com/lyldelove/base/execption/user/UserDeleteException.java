package com.lyldelove.base.execption.user;

import com.lyldelove.base.execption.constant.ExceptionCode;

/**
 * @author lyldelove
 * @title UserDeleteException 用户已删除异常
 * @date 2020/5/20 7:20
 */
public class UserDeleteException extends UserException{

    public UserDeleteException() {
        super(ExceptionCode.USER_DELETE, null);
    }
}
