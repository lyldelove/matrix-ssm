package com.lyldelove.entity.system;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * sys_login_log
 */
@Data
public class SysLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
    private Long logId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * IP地址
     */
    private String ipAddr;

    /**
     * 登录地址
     */
    private String loginLocation;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 登录状态 0成功 1失败
     */
    private String status;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;
}