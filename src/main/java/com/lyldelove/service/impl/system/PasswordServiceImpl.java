package com.lyldelove.service.impl.system;

import com.lyldelove.dto.system.User;
import com.lyldelove.service.intf.system.PasswordService;
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
        return null;
    }

    @Override
    public boolean matches(User user, String password) {
        return false;
    }
}
