package com.lyldelove.service.intf.system;

import com.lyldelove.entity.system.SysUser;

/**
 * @author lyldelove
 * @title LoginService 登录
 * @date 2020/3/23 23:20
 */
public interface LoginService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    SysUser login(String username, String password);
}
