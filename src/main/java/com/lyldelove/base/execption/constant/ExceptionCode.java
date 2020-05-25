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

    /**
     * 模块：MODULE_USER
     * 用户不存在
     */
    String USER_NOT_EXIST = "user.not.exist";

    /**
     * 模块：MODULE_USER
     * 用户禁用
     */
    String USER_DISABLE = "user.disable";

    /**
     * 模块：MODULE_USER
     * 用户已删除
     */
    String USER_DELETE = "user.delete";

    /**
     * 模块：MODULE_USER
     * 用户输入密码错误次数超过限制
     */
    String USER_PASSWORD_RETRY_LIMIT_EXCEED = "user.password.retry.limit.exceed";

    /**
     * 模块：MODULE_USER
     * 用户密码不匹配
     */
    String USER_PASSWORD_NOT_MATCH = "user.password.not.match";
}
