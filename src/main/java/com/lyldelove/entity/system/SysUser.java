package com.lyldelove.entity.system;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 类型:Y默认用户,N非默认用户
     */
    private String userType;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobilePhone;

    /**
     * 性别，0 男，1 女，2 未知
     */
    private String sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 账号状态，0 正常，1 停用
     */
    private String status;

    /**
     * 删除标识，0 正常，1 删除
     */
    private String deleteFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}