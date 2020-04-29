package com.lyldelove.base.execption.user;

/**
 * @author lyldelove
 * @title CaptchaException 验证码错误异常
 * @date 2020/4/30 7:20
 */
public class CaptchaException extends UserException {

    public CaptchaException() {
        super("user.captcha.error", null);
    }
}
