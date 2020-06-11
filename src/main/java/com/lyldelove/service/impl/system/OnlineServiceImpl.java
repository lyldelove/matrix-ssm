package com.lyldelove.service.impl.system;

import com.lyldelove.dao.system.SysUserOnlineMapper;
import com.lyldelove.entity.system.SysUserOnline;
import com.lyldelove.service.intf.system.OnlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lyldelove
 * @title OnlineServiceImpl
 * @date 2020/6/10 7:08
 */
@Service
public class OnlineServiceImpl implements OnlineService {

    @Resource
    private SysUserOnlineMapper sysUserOnlineMapper;

    @Override
    public SysUserOnline selectOnlineById(String sessionId) {
        return sysUserOnlineMapper.selectByPrimaryKey(sessionId);
    }

    @Override
    public void deleteOnlineById(String sessionId) {
        sysUserOnlineMapper.deleteByPrimaryKey(sessionId);
    }

    @Override
    public void saveOnline(SysUserOnline online) {
        sysUserOnlineMapper.insert(online);
    }
}
