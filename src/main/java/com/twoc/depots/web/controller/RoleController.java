package com.twoc.depots.web.controller;

import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Role;
import com.twoc.depots.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色Controller
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/add")
    public ResultDto addRole(@Validated @RequestBody RoleDTO role){
        return roleService.addRole(role);
    }

    /**
     * 修改角色状态

     * @return
     */
    @PostMapping(value = "/update/{roleId}/{roleStaus}",consumes = "application/json")
    public ResultDto updateRole(@PathVariable Integer roleId, @PathVariable Integer roleStaus){
        RoleDTO role=new RoleDTO();
        role.setRoleId(roleId);
        role.setRoleStatus(roleStaus);
        return roleService.updateRole(role);
    }

    /**
     * 查询列表
     * @param role
     * @return
     */
    @GetMapping("/list")
    public LayuiData selectList(RoleDTO role){
        LayuiData layuiData = roleService.selectList(role);
        return layuiData;
    }

    /**
     * 查询角色信息
     * @return
     */
    @PostMapping("/selectById/{roleId}")
    public Role selectById(@PathVariable Integer roleId){
        return roleService.selectById(roleId);

    }

    @PostMapping("/updates")
    public ResultDto updates(@Validated(value =RoleDTO.UpdateRole.class ) @RequestBody RoleDTO roleDTO){
        return roleService.updates(roleDTO);
    }
}
