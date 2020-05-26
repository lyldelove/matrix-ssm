package com.lyldelove.service.impl.system;

import com.lyldelove.service.intf.system.PasswordService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

/**
 * @author lyldelove
 * @title PasswordServiceImpl 密码
 * @date 2020/5/25 7:32
 */
@Service
public class PasswordServiceImpl implements PasswordService {

    @Override
    public String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex();
    }

    @Override
    public boolean matches(String username, String password, String salt, String inputPassword) {
        return password.equals(encryptPassword(username, inputPassword, salt));
    }
}
