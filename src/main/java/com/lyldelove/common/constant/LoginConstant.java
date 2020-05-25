package com.lyldelove.common.constant;

public interface LoginConstant {

    /**
     * 登录成功
     */
    String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    String LOGIN_FAIL = "Error";

    /**
     * 用户验证码错误
     */
    String USER_CAPTCHA_ERROR = "user.captcha.error";

    /**
     * 登录名/密码为空
     */
    String USER_LOGIN_PARAM_NULL = "user.login.param.null";

    /**
     * 用户不存在
     */
    String USER_NOT_EXIST = "user.not.exist";

    /**
     * 用户禁用
     */
    String USER_DISABLE = "user.disable";

    /**
     * 用户已删除
     */
    String USER_DELETE = "user.delete";

    /**
     * 用户输入密码错误次数超过限制
     */
    String USER_PASSWORD_RETRY_LIMIT_EXCEED = "user.password.retry.limit.exceed";

    /**
     * 用户密码不匹配
     */
    String USER_PASSWORD_NOT_MATCH = "user.password.not.match";

    /**
     * 用户登录成功
     */
    String USER_LOGIN_SUCCESS = "user.login.success";
}
