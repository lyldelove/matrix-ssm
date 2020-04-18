package com.lyldelove.service.impl.system;

import com.lyldelove.base.async.AsyncFactory;
import com.lyldelove.base.async.AsyncManager;
import com.lyldelove.base.util.ServletUtil;
import com.lyldelove.base.util.StringUtil;
import com.lyldelove.common.constant.ShiroConstant;
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
        //判断验证码是否有异常
        //if(!StringUtil.isEmpty(ServletUtil.getRequest().getAttribute(ShiroConstant.CAPTCHA_EXCEPTION))) {
            AsyncManager.getManager().execute(AsyncFactory.saveLoginRecord(username, "test", "test"));
        //}
        return null;
    }
}
