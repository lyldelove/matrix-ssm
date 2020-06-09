package com.lyldelove.dao.system;

import com.lyldelove.entity.system.SysUserOnline;

public interface SysUserOnlineMapper {

    int deleteByPrimaryKey(String sessionId);

    int insert(SysUserOnline record);

    SysUserOnline selectByPrimaryKey(String sessionId);

    int updateByPrimaryKey(SysUserOnline record);
}