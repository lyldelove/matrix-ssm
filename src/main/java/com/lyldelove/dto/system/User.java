package com.lyldelove.dto.system;

import com.lyldelove.entity.system.SysDept;
import com.lyldelove.entity.system.SysRole;
import com.lyldelove.entity.system.SysUser;

import java.util.List;

public class User {

    private SysUser sysUser;

    private SysDept sysDept;

    private List<SysRole> sysRoles;
}
