package com.attraction.modular.base.controller;

import com.attraction.modular.member.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class BasePageController {
    @RequestMapping(value = {"/","/index"})
    public ModelAndView index(HttpSession session, ModelAndView mav){
        Member member = (Member) session.getAttribute("member");
        mav.addObject("member", member);
        mav.setViewName("/index");
        return mav;
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
