package com.lyldelove.entity.system;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.lyldelove.dto.system.OnlineSession;
import lombok.Data;

/**
 * sys_user_online
 * @author 
 */
@Data
public class SysUserOnline implements Serializable {
    /**
     * 用户会话ID
     */
    private String sessionId;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 登录IP地址
     */
    private String ipAddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 状态
     */
    private String status;

    /**
     * session创建时间
     */
    private LocalDateTime startTimestamp;

    /**
     * session最后访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     * 超时时间，单位为分钟
     */
    private Integer expireTime;

    /** 备份的当前用户会话 */
    private OnlineSession session;

    private static final long serialVersionUID = 1L;
}