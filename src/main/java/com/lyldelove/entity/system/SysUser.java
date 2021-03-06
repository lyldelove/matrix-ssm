package com.lyldelove.entity.system;

import com.lyldelove.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * sys_user
 */
@Getter
@Setter
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
     * 删除标识，0 正常，2 删除
     */
    private String deleteFlag;

    /**
     * 最后登录IPe
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 根据userId判断是否是管理员账号
     * @param userId
     * @return
     */
    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    /**
     * 根据userId判断是否是管理员账号
     * @return
     */
    public boolean isAdmin() {
        return isAdmin(this.userId);
    }
}