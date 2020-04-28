package com.lyldelove.dao.system;

import com.lyldelove.entity.system.SysLoginLog;

public interface SysLoginLogMapper {

    int deleteByPrimaryKey(Long logId);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);
}