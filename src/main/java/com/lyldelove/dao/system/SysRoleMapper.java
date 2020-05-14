package com.lyldelove.dao.system;

import com.lyldelove.entity.system.SysRole;

public interface SysRoleMapper {

    int deleteByPrimaryKey(Long roleId);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKey(SysRole record);
}