package com.lyldelove.common.util;

import com.lyldelove.dto.system.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyldelove
 * @title TreeUtil 加载树的工具类
 * @date 2020/6/1 7:14
 */
public class TreeUtil {

    public static List<Menu> getChildPerms(List<Menu> menuList, int parentId) {
        List<Menu> result = new ArrayList<>();

        for (Menu menu : menuList) {
            //根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (menu.getParentId() == parentId) {
                recursion(menuList, menu);
                result.add(menu);
            }
        }

        return result;
    }

    /**
     * 递归树，生成对象
     * @param menuList
     * @param parentMenu
     */
    private static void recursion(List<Menu> menuList, Menu parentMenu) {
        //获取下一级子节点列表
        List<Menu> childList = getChildList(menuList, parentMenu);

        parentMenu.setChildren(childList);
        //判断子节点是否还有子节点
        for (Menu childMenu : childList) {
            if (hasChild(menuList, childMenu)) {
                recursion(menuList, childMenu);
            }
        }
    }

    /**
     * 获取传入Menu的下一级子节点列表
     * @param menuList
     * @param parentMenu
     * @return
     */
    private static List<Menu> getChildList(List<Menu> menuList, Menu parentMenu) {
        List<Menu> result = new ArrayList<>();

        for (Menu menu : menuList) {
            if (menu.getParentId().longValue() == parentMenu.getMenuId().longValue()) {
                result.add(menu);
            }
        }

        return result;
    }

    /**
     * 判断传入的节点是否有子节点
     * @param menuList
     * @param parentMenu
     * @return
     */
    private static boolean hasChild(List<Menu> menuList, Menu parentMenu) {
        return getChildList(menuList, parentMenu).size() > 0;
    }
}
