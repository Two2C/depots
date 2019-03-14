package com.twoc.depots.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Role;
import com.twoc.depots.entity.User;
import com.twoc.depots.mapper.UserMapper;
import com.twoc.depots.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public LayuiData selectList(UserDTO userDTO) {
        Page userPage = new Page(userDTO.getPage(), userDTO.getLimit());
        QueryWrapper queryWrapper = new QueryWrapper<Role>();
        if (userDTO.getEmployeeName() != null && userDTO.getEmployeeName() != "") {
            queryWrapper.eq("employee_name", userDTO.getEmployeeName());
        }
        if (userDTO.getUserId() != null) {
            queryWrapper.eq("user_id", userDTO.getUserId());
        }
        if (userDTO.getUserStatus() != null) {
            queryWrapper.eq("user_status", userDTO.getUserStatus());
        }
        IPage iPage = userMapper.selectPage(userPage, queryWrapper);
        return LayuiData.SETDATA(0, "成功", new Long(iPage.getTotal()).intValue(), iPage.getRecords(), iPage);
    }

    @Override
    public ResultDto updateUserStatus(UserDTO user) {
        int result = userMapper.update(new User().setUserStatus(user.getUserStatus()), new UpdateWrapper<User>().eq("user_id", user.getUserId()));
        String res = "";
        if (user.getUserStatus() == 3) {
            res = "启用";
        }
        if (user.getUserStatus() == 2) {
            res = "禁用";
        }
        if (user.getUserStatus() == 1) {
            res = "确认";
        }
        if (result > 0) {
            return ResultDto.succeedResult(res + "成功");
        }
        return ResultDto.failResult(res + "失败");
    }

    @Override
    public ResultDto addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        int result = userMapper.insert(user);
        if(result>0){
            return ResultDto.succeedResult("用户添加成功");
        }
        return ResultDto.failResult("用户添加失败");
    }

    @Override
    public User selectById(Integer userId) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("user_id", userId));
    }

    @Override
    public ResultDto updateUser(UserDTO userDTO) {
        int result=userMapper.updateUser(userDTO);
        if(result>0){
            return ResultDto.succeedResult("修改成功");
        }
        return ResultDto.failResult("修改失败");
    }
}
