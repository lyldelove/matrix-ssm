package com.lyldelove.service.intf.system;

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
     * @param username
     * @param password
     * @param salt
     * @param inputPassword
     * @return
     */
    boolean matches(String username, String password, String salt, String inputPassword);
}
