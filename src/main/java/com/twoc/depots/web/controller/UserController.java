package com.twoc.depots.web.controller;


import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.common.LayuiData;
import com.twoc.depots.common.ResultDto;
import com.twoc.depots.entity.Module;
import com.twoc.depots.entity.User;
import com.twoc.depots.service.RoleService;
import com.twoc.depots.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
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
    @RequestMapping(value = "/login_do",method = RequestMethod.GET)
    public ResultDto doLogin(UserDTO userDTO, HttpSession session,
                             Map<String, Object> map){
        System.out.println("aaaaaa");
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(userDTO.getUserName(), userDTO.getUserPwd());
            // 设置为rememberme
            token.setRememberMe(true);
            try {
                // 执行登录.
                currentUser.login(token);
            }
            // 所有认证时异常的父类
            catch (AuthenticationException ae) {
                map.put("password", "输入的用户名或密码错误");
                return ResultDto.failResult("失败");
            }
        }

        session.setAttribute("loginUser", "user");
        return ResultDto.succeedResult("成功");

    }

    /**
     * 用户分配权限
     * @param roleIds
     * @param userId
     * @return
     */
    @PostMapping(value = "/quanx/{userId}")
    public ResultDto getRole(@RequestBody Integer[] roleIds, @PathVariable String userId){
        return userService.getRole(roleIds,userId);
    }




}
