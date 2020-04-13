package com.lyldelove.service.intf.system;

import com.lyldelove.entity.system.SysUser;

/**
 * @author lyldelove
 * @title LoginService 登录
 * @date 2020/3/23 23:20
 */
public interface LoginService {

    /**
     * 111
     * @param username
     * @param password
     * @return
     */
    SysUser login(String username, String password);
}
