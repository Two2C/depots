package com.twoc.depots.service;

import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Role;

import java.util.List;


public interface RoleService {
    /**
     * 添加角色
     * @param role
     * @return
     */
    ResultDto addRole(RoleDTO role);

    /**
     * 修改角色状态
     * @param role
     * @return
     */
    ResultDto updateRole(RoleDTO role);

    /**
     * 查询列表
     * @param role
     * @return
     */
    LayuiData selectList(RoleDTO role);

    /**
     * 查询角色信息
     * @param roleId
     * @return
     */
    Role selectById(Integer roleId);

    /**
     * 修改角色信息
     * @param roleDTO
     * @return
     */
    ResultDto updates(RoleDTO roleDTO);
}
