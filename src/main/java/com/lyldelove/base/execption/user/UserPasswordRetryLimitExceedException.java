package com.lyldelove.base.execption.user;

import static com.lyldelove.base.execption.constant.ExceptionCode.USER_PASSWORD_RETRY_LIMIT_EXCEED;

/**
 * @author lyldelove
 * @title UserPasswordRetryLimitExceedException 用户密码输入错误超过限制异常
 * @date 2020/5/26 6:01
 */
public class UserPasswordRetryLimitExceedException extends UserException {

    public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super(USER_PASSWORD_RETRY_LIMIT_EXCEED, new Object[] { retryLimitCount });
    }
}
