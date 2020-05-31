package com.lyldelove.common.util;

import com.lyldelove.dto.system.Menu;
import com.lyldelove.entity.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyldelove
 * @title TreeUtil 加载树的工具类
 * @date 2020/6/1 7:14
 */
public class TreeUtil {

    public static List<Menu> getChildPerms(List<Menu> menulist, int parentId) {
        List<Menu> result = new ArrayList<>();

        for (Menu menu : menulist) {
            //根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (menu.getParentId() == parentId) {
                recursion(menulist, menu);
                result.add(menu);
            }
        }

        return result;
    }

    private static void recursion(List<Menu> menulist, Menu menu) {

    }
}
