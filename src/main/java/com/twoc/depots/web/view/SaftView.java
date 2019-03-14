package com.twoc.depots.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SaftView {
    @GetMapping("/role/toRole")
    public String toRole(){
        return "role";
    }
    @GetMapping(value = "/user/toUser")
    public String toUser(){
        return "user";
    }
    @GetMapping(value = "/b2")
    public String demo2(){
        return "index";
    }
    @GetMapping(value = "/ccc")
    public String demo3(){
        return "user";
    }

}
