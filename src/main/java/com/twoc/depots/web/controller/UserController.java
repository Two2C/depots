package com.twoc.depots.web.controller;


import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Module;
import com.twoc.depots.entity.User;
import com.twoc.depots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     * @param userDTO
     * @return
     */
    @GetMapping(value = "/list")
    public LayuiData selectList(UserDTO userDTO){
        return userService.selectList(userDTO);

    }

    /**
     * 修改用户状态
     * @return
     */
    @PostMapping(value = "/update/{userId}/{userStaus}",consumes = "application/json")
    public ResultDto updateUserStatus(@PathVariable Integer userId, @PathVariable Integer userStaus){
        UserDTO user=new UserDTO();
        user.setUserId(userId);
        user.setUserStatus(userStaus);
        return userService.updateUserStatus(user);
    }

    /**
     * 添加用户信息
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/add",consumes = "application/json")
    public ResultDto addUser(@Validated(value = UserDTO.Add.class) @RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    @PostMapping(value = "/selectById/{userId}",consumes = "application/json")
    public User selectById(@PathVariable Integer userId){
        return userService.selectById(userId);
    }

    /**
     * 修改用户信息
     * @param userDTO
     * @return
     */
    @PostMapping(value = "/updates",consumes = "application/json")
    public ResultDto updateUser(@Validated(value = UserDTO.Updates.class) @RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }



}
