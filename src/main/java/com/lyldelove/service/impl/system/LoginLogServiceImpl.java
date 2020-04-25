package com.lyldelove.service.impl.system;

import com.lyldelove.dao.system.SysLoginLogMapper;
import com.lyldelove.entity.system.SysLoginLog;
import com.lyldelove.service.intf.system.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lyldelove
 * @title LoginLogServiceImpl 登录日志
 * @date 2020/4/25 7:20
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    /**
     * 保存登录日志
     * @param loginLog SysLoginLog
     */
    @Override
    public void saveLoginLog(SysLoginLog loginLog) {
        sysLoginLogMapper.insert(loginLog);
    }
}
