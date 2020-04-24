package com.lyldelove.entity.system;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SysLoginLog {

    private Long logId;

    private String loginName;

    private String ipAddr;

    private String loginLocation;

    private String os;

    private String browser;

    private Integer status;

    private String message;

    private LocalDateTime loginTime;
}