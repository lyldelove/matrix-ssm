package com.lyldelove.service.intf.system;

import com.lyldelove.dto.system.Menu;
import com.lyldelove.entity.system.SysUser;

import java.util.List;

public interface MenuService {

    List<Menu> selectMenuByUser(SysUser sysUser);
}
