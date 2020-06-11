package com.lyldelove.service.intf.system;

import com.lyldelove.entity.system.SysUserOnline;

public interface OnlineService {

    SysUserOnline selectOnlineById(String sessionId);

    void deleteOnlineById(String sessionId);

    void saveOnline(SysUserOnline online);
}
