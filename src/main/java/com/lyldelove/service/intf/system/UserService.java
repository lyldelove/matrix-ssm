package com.lyldelove.service.intf.system;

import com.lyldelove.entity.system.SysUser;

public interface UserService {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    SysUser selectUserByLoginName(String username);
}
