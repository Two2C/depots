package com.twoc.depots.service;


import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    /**
     * 查询用户列表
     * @param userDTO
     * @return
     */
    LayuiData selectList(UserDTO userDTO);

    /**
     * 修改用户状态
     * @param user
     * @return
     */
    ResultDto updateUserStatus(UserDTO user);

    /**
     * 添加用户
     * @param userDTO
     * @return
     */
    ResultDto addUser(UserDTO userDTO);

    /**
     * 通过id查询
     * @param userId
     * @return
     */
    User selectById(Integer userId);

    /**
     * 修改用户信息
     * @param userDTO
     * @return
     */
    ResultDto updateUser(UserDTO userDTO);

    /**
     * 通过用户名查找用户信息
     * @param userName
     * @return
     */
    UserDTO selectByName(String userName);

    /**
     * 登录
     * @param userDTO
     * @return
     */
    ResultDto selectUser(UserDTO userDTO);

    /**
     * 用户分配权限
     * @param roleIds
     * @param userId
     * @return
     */
    ResultDto getRole(Integer[] roleIds, String userId);
}
