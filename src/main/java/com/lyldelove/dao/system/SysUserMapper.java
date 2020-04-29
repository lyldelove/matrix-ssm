package com.lyldelove.dao.system;

import com.lyldelove.entity.system.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKey(SysUser record);
}