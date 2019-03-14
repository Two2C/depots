package com.twoc.depots.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Role;
import com.twoc.depots.mapper.RoleMapper;
import com.twoc.depots.mapper.URMapper;
import com.twoc.depots.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private URMapper urMapper;
    @Override
    public ResultDto addRole(RoleDTO roles) {
        Role role=new Role();
        BeanUtils.copyProperties(roles,role);
        int result= roleMapper.insert(role);
        if(result>0){
            return ResultDto.succeedResult("添加成功");
        }
        return ResultDto.succeedResult("添加失败");
    }

    @Override
    public ResultDto updateRole(RoleDTO roles) {
        int result=roleMapper.update(new Role().setRoleStatus(roles.getRoleStatus()),new UpdateWrapper<Role>().eq("role_id",roles.getRoleId()));
        String res="";
        if(roles.getRoleStatus()==3){
            res="启用";
        }
        if(roles.getRoleStatus()==2){
            res="禁用";
        }
        if(roles.getRoleStatus()==1){
            res="确认";
        }
        if(result>0){
            return ResultDto.succeedResult(res+"成功");
        }
        return ResultDto.failResult(res+"失败");
    }
    @Override
    public LayuiData selectList(RoleDTO role) {
        Page userPage=new Page(role.getPage(),role.getLimit());
        QueryWrapper queryWrapper=new QueryWrapper<Role>();
        if(role.getRoleName()!=null&&role.getRoleName()!=""){
            queryWrapper.eq("role_name",role.getRoleName());
        }
        if(role.getRoleId()!=null){
            queryWrapper.eq("role_id",role.getRoleId());
        }
        if(role.getRoleRemark()!=null&&role.getRoleRemark()!=""){
            queryWrapper.eq("role_remark",role.getRoleRemark());
        }
        if(role.getRoleStatus()!=null){
            queryWrapper.eq("role_status",role.getRoleStatus());
        }
        IPage iPage = roleMapper.selectPage(userPage, queryWrapper);
        return LayuiData.SETDATA(0,"成功",new Long(iPage.getTotal()).intValue(),iPage.getRecords(),iPage);
    }


    @Override
    public Role selectById(Integer roleId) {
        return roleMapper.selectOne(new QueryWrapper<Role>().eq("role_id", roleId));

    }

    @Override
    public ResultDto updates(RoleDTO roleDTO) {
        Role role=new Role();
        if(roleDTO.getRoleName()!=null){
            role.setRoleName(roleDTO.getRoleName());
        }
        if(roleDTO.getRoleRemark()!=null){
            role.setRoleRemark(roleDTO.getRoleRemark());
        }
        int result=roleMapper.update(role,new UpdateWrapper<Role>().eq("role_id",roleDTO.getRoleId()));
        if(result>0){
            return ResultDto.succeedResult("修改成功");
        }
        return ResultDto.failResult("修改失败");

    }
}
