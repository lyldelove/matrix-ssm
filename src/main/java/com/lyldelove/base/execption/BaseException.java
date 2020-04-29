package com.lyldelove.base.execption;

import com.lyldelove.common.util.MessageUtil;
import org.springframework.util.StringUtils;

/**
 * @author lyldelove
 * @title BaseException 异常的基础类
 * @date 2020/4/30 6:57
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String message;


    public BaseException(String module, String code, Object[] args, String message) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.message = message;
    }

    public BaseException(String module, String code, Object[] args) {
        this(module, code, args, null);
    }

    public BaseException(String module, String message) {
        this(module, null, null, message);
    }

    public BaseException(String code, Object[] args) {
        this(null, code, args, null);
    }

    public BaseException(String message) {
        this(null, null, null, message);
    }

    @Override
    public String getMessage() {
        String msg = null;
        if (!StringUtils.isEmpty(code)) {
            msg = MessageUtil.message(code, args);
        }
        if (msg == null) {
            msg = message;
        }
        return msg;
    }

    public String getModule() {
        return module;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" + "module='" + module + '\'' + ", message='" + message + '\'' + '}';
    }
}
