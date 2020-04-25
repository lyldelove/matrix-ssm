package com.lyldelove.entity.system;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SysUser {

    private Long userId;

    private Long deptId;

    private String loginName;

    private String userName;

    private String userType;

    private String password;

    private String salt;

    private String email;

    private String mobilePhone;

    private String sex;

    private String avatar;

    private Integer status;

    private String deleteFlag;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private String remark;
}