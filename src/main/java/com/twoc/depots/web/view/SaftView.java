package com.twoc.depots.web.view;

import com.twoc.depots.bean.dto.RoleDTO;
import com.twoc.depots.bean.dto.UserDTO;
import com.twoc.depots.entity.Role;
import com.twoc.depots.service.RoleService;
import com.twoc.depots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SaftView {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    /**
     * 角色页面
     * @return
     */
    @GetMapping("/role/toRole")
    public String toRole(){
        return "role";
    }

    /**
     * 用户页面
     * @return
     */
    @GetMapping(value = "/user/toUser")
    public String toUser(){
        return "user";
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping(value = "/saft/login_to")
    public String toLogin(){
        return "loginIndex";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping(value = "/saft/home_to")
    public String toHome(){
        return "index";
    }
    @GetMapping(value = "/user/doUser/{userId}")
    public String doUser(@PathVariable Integer userId, Model model, HttpSession session, HttpServletRequest request){
        List<RoleDTO> roles = roleService.selectRoleByUser(userId);
        model.addAttribute("roles",roles);
        request.setAttribute("nowUserId",userId);
        session.setAttribute("nowUserId",userId);
        return "editUser";
    }


}
