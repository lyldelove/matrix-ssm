package com.lyldelove.service.impl.system;

import com.lyldelove.common.util.TreeUtil;
import com.lyldelove.dao.system.SysMenuMapper;
import com.lyldelove.dto.system.Menu;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lyldelove
 * @title MenuServiceImpl
 * @date 2020/5/29 6:40
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<Menu> selectMenuByUser(SysUser sysUser) {
        List<Menu> menuList = new LinkedList<>();

        //管理员账号默认拥有所有权限，方便于权限的分配
        if (sysUser.isAdmin()) {
            menuList = sysMenuMapper.selectMenuNormalAll();
        } else {
            menuList = sysMenuMapper.selectMenuByUserId(sysUser.getUserId());
        }

        return TreeUtil.getChildPerms(menuList, 0);
    }
}
