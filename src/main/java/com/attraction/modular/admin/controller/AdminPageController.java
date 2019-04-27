package com.attraction.modular.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * 控制跳转 Controller
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @RequestMapping("/error/noPower")
    public String toNoPower() {
        return "error/noPower";
    }

    @RequestMapping("{anything}/logout")
    public String logout(@PathVariable String anything, HttpSession session){
        session.invalidate();//清除 session 中的所有信息
        return "/admin/login";
    }

    @RequestMapping("/log")
    public String logPage(HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId");
        Integer userInfo = (Integer) session.getAttribute("userInfo");
        if(null != userId && null != userInfo) {
            return "menu";
        }
        return "/admin/login";
    }
}
