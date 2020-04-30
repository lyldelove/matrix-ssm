package com.lyldelove.base.execption.user;

import com.lyldelove.base.execption.constant.ExceptionCode;

/**
 * @author lyldelove
 * @title CaptchaException 验证码错误异常
 * @date 2020/4/30 7:20
 */
public class CaptchaException extends UserException {

    public CaptchaException() {
        super(ExceptionCode.USER_CAPTCHA_ERROR, null);
    }
}
