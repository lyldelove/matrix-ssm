package com.lyldelove.entity.system;

import com.lyldelove.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * sys_menu
 * @author 
 */
@Getter
@Setter
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 打开方式（menuItem页签 menuBlank新窗口）
     */
    private String target;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;

    /**
     * 菜单状态1显示 0隐藏）
     */
    private String visible;

    /**
     * 权限表示
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;
}