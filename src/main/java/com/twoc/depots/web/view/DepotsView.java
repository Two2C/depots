package com.twoc.depots.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepotsView {
    @RequestMapping("plan/toPlan")
    public String toPlan(){
        return "plan";
    }
    @RequestMapping("depot/toCome")
    public String toCome(){
        return "come";
    }
    @RequestMapping("depot/toOut")
    public String toOut(){
        return "out";
    }
    @RequestMapping("goods/toGoods")
    public String toGoods(){
        return "goods";
    }
}
