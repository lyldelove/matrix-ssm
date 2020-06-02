package com.lyldelove.dao.system;

import com.lyldelove.entity.system.SysConfig;

public interface SysConfigMapper {

    int deleteByPrimaryKey(Long configId);

    int insert(SysConfig record);

    SysConfig selectByPrimaryKey(Long configId);

    int updateByPrimaryKey(SysConfig record);

    SysConfig selectConfig(SysConfig sysConfig);
}