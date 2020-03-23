package com.lyldelove.entity.system;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class SysUser {

    private Long userId;

    private Long deptId;

    private String loginName;

    private String userName;

    private String userType;

    private String email;

    private String phonenumber;

    private String sex;

    private String avatar;

    private String password;

    private String salt;

    private String status;

    private String delFlag;

    private String loginIp;

    private Date loginDate;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String remark;
}