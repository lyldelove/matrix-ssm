package com.lyldelove.base.execption.user;

import com.lyldelove.base.execption.BaseException;

/**
 * @author lyldelove
 * @title UserException User模块异常
 * @date 2020/4/30 7:25
 */
public class UserException extends BaseException {

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
