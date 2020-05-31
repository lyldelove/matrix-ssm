package com.lyldelove.dao.system;

import com.lyldelove.dto.system.Menu;
import com.lyldelove.entity.system.SysMenu;
import java.util.List;

public interface SysMenuMapper {

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKey(SysMenu record);

    /**
     * 查询系统正常显示菜单（不含按钮）
     * @return
     */
    List<Menu> selectMenuNormalAll();

    /**
     * 根据用户ID查询菜单
     * @param userId
     * @return
     */
    List<Menu> selectMenuByUserId(Long userId);
}