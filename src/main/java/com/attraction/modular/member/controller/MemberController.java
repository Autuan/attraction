package com.attraction.modular.member.controller;

import com.attraction.common.entity.ReturnResult;
import com.attraction.common.util.LoginUtil;
import com.attraction.modular.base.service.IBaseService;
import com.attraction.modular.member.entity.Member;
import com.attraction.modular.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Validated
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private IMemberService memberService;
    @Autowired
    private IBaseService baseService;
    /**
     * 增加
     * @param member
     * @return
     */
    @RequestMapping("/insertMember")
    public ReturnResult insertMember(Member member) {
        try {
            memberService.insertMember(member);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error();
        }
        return ReturnResult.ok();
    }

    /**
     * 修改
     * @param member
     * @return
     */
    @RequestMapping("/updateMember")
    public ReturnResult updateMember(Member member){
        try {
            memberService.updateMember(member);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error();
        }
        return ReturnResult.ok();
    }

    /**
     * 删除部门
     * @param memberId
     * @return
     */
    @RequestMapping("/deleteMember")
    public ReturnResult deleteMember(Integer memberId){
        try {
            memberService.deleteMember(memberId);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error();
        }
        return ReturnResult.ok();
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @param confirmPassword 确认密码
     * @return
     */
    @RequestMapping("/sign")
    public ReturnResult sign(String username,
                              String password,
                             String confirmPassword){
        baseService.checkStrParamNotBlank(username,password,confirmPassword);
        if(!password.equals(confirmPassword)){
            return ReturnResult.error("两次密码不一致");
        }
        int result = memberService.insertMember(new Member(username, LoginUtil.getSHA256Str(password)));
        return result == 1 ? ReturnResult.ok() : ReturnResult.error("注册失败,请稍后重试");
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ReturnResult login(String username, String password,
                              HttpSession session){
        baseService.checkStrParamNotBlank(username,password);
        // 字符加密
        Member member = memberService.userLogin(username, LoginUtil.getSHA256Str(password));
        if ( null == member) {
            return ReturnResult.error("用户名或密码错误");
        } else {
            session.setAttribute("member", member);
            session.setMaxInactiveInterval(30*60);
        }
        return ReturnResult.ok();
    }

}
