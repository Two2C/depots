package com.twoc.depots.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepotsView {
    @RequestMapping("plan/toPlan")
    public String toPlan(){
        return "plan";
    }
}
