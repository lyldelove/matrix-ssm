package com.lyldelove.entity.system;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * sys_dept
 */
@Data
public class SysDept implements Serializable {
    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门显示顺序
     */
    private Integer orderNum;

    /**
     * 部门负责人
     */
    private String leader;

    /**
     * 部门电话
     */
    private String phone;

    /**
     * 部门邮箱
     */
    private String email;

    /**
     * 状态，0 正常，1 停用
     */
    private String status;

    /**
     * 删除标识，0 正常，1 删除
     */
    private String deleteFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}