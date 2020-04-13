package com.lyldelove.service.impl.system;

import com.lyldelove.base.async.AsyncManager;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.LoginService;
import org.springframework.stereotype.Service;

import java.util.TimerTask;

/**
 * @author lyldelove
 * @title LoginServiceImpl
 * @date 2020/3/23 23:23
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public SysUser login(String username, String password) {
        AsyncManager.getManager().execute(new TimerTask() {
            @Override
            public void run() {
                System.out.println(123);
            }
        });
        return null;
    }
}
