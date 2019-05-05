package com.attraction.modular.base.controller;

import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.service.IAttractionService;
import com.attraction.modular.member.entity.Member;
import com.attraction.modular.recommend.service.IRecommendService;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BasePageController {
    @Autowired
    private IRecommendService recommendService;
    @Autowired
    private IAttractionService attractionService;

    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "../front_index";
    }
    @RequestMapping("/front_index")
    public ModelAndView frontIndex(HttpSession session, ModelAndView mav) {
        Member member = (Member) session.getAttribute("member");
        mav.addObject("member", member);
        List<Attraction> recommends = null;
        if (null != member) {
            recommends = recommendService.attractionRecommend(member.getId());
        }
        if (null == recommends) {
            recommends = attractionService.list(0, 5);
        }
        mav.addObject("recommends", recommends);
        mav.setViewName("../front_index");
        return mav;
    }

    @RequestMapping("/member")
    public String member() {
        return "/member/member";
    }

    @RequestMapping("/detail")
    public String detail() {
        return "/attraction/detail";
    }
}