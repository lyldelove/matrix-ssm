package com.lyldelove.base.execption.constant;

/**
 * @author lyldelove
 * @title ExceptionCode 异常代码常量
 * @date 2020/5/1 6:31
 */
public interface ExceptionCode {

    /**
     * 模块：MODULE_USER
     * 用户验证码错误
     */
    String USER_CAPTCHA_ERROR = "user.captcha.error";

    /**
     * 模块：MODULE_USER
     * 登录名/密码为空
     */
    String USER_LOGIN_PARAM_NULL = "user.login.param.null";
}
