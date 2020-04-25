package com.lyldelove.service.intf.system;

import com.lyldelove.entity.system.SysLoginLog;

public interface LoginLogService {

    /**
     * 保存登录日志
     * @param loginLog SysLoginLog
     */
    void saveLoginLog(SysLoginLog loginLog);
}
