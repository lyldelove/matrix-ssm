package com.lyldelove.base.execption;

import com.lyldelove.base.system.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lyldelove
 * @title GlobalExceptionHandler 全局异常统一处理类
 * @date 2020/5/4 6:36
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理认证失败异常
     * @param e AuthenticationException
     * @return Result
     */
    @ExceptionHandler(AuthenticationException.class)
    public Result handleAuthenticationException(AuthenticationException e) {
        log.info(e.getMessage(), e);

        System.out.println(123);
        return null;
    }
}
