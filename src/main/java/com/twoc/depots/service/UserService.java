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
     * 查询
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
}
