package com.attraction.modular.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasePageController {
    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "/index";
    }

    @RequestMapping("/member")
    public String member(){
        return "/member/member";
    }

    @RequestMapping("/detail")
    public String detail(){
        return "/attraction/detail";
    }
}
