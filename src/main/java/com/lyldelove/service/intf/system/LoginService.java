package com.lyldelove.service.intf.system;

import com.lyldelove.entity.system.SysUser;
import org.springframework.stereotype.Service;

/**
 * @author lyldelove
 * @title LoginService 登录
 * @date 2020/3/23 23:20
 */
@Service
public interface LoginService {

    SysUser login(String username, String password);
}
