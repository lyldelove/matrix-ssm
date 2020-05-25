package com.lyldelove.service.intf.system;

import com.lyldelove.dto.system.User;

public interface PasswordService {

    /**
     * 加密密码
     * @param username
     * @param password
     * @param salt
     * @return
     */
    String encryptPassword(String username, String password, String salt);

    /**
     * 判断密码是否相等
     * @param user
     * @param password
     * @return
     */
    boolean matches(User user, String password);
}
