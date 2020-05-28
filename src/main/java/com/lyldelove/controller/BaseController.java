package com.lyldelove.controller;

import com.lyldelove.base.system.Result;
import com.lyldelove.common.util.ShiroUtil;
import com.lyldelove.dto.system.User;
import com.lyldelove.entity.system.SysUser;

/**
 * @author lyldelove
 * @title BaseController Controller基类
 * @date 2020/5/29 6:08
 */
public class BaseController {

    /**
     * 返回成功
     */
    public Result success() {
        return Result.success();
    }

    /**
     * 返回成功消息
     */
    public Result success(String message) {
        return Result.success(message);
    }

    /**
     * 返回失败消息
     */
    public Result error() {
        return Result.error();
    }
    
    /**
     * 返回失败消息
     */
    public Result error(String message) {
        return Result.error(message);
    }

    /**
     * 从Shiro Subject中获取用户信息
     * @return
     */
    public SysUser getSysUser() {
        return ShiroUtil.getSysUser();
    }

    /**
     * 设置用户信息到Shiro中
     * @param sysUser
     */
    public void setSysUser(SysUser sysUser) {
        ShiroUtil.setSysUser(sysUser);
    }

    /**
     * 获取用户User Id
     * @return
     */
    public Long getUserId() {
        return getSysUser().getUserId();
    }

    /**
     * 获取用户登录名
     * @return
     */
    public String getLoginName() {
        return getSysUser().getLoginName();
    }

}
