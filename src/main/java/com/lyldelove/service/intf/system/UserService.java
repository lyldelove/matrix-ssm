package com.lyldelove.service.intf.system;

import com.lyldelove.dto.system.User;

public interface UserService {

    /**
     * 根据用户名查询用户
     * @param loginName
     * @return
     */
    User selectUserByLoginName(String loginName);
}
