package com.attraction.modular.attraction.controller;

import com.attraction.common.entity.ReturnResult;
import com.attraction.common.exception.CheckException;
import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.service.IAttractionService;
import com.attraction.modular.comment.entity.Comment;
import com.attraction.modular.comment.service.ICommentService;
import com.attraction.modular.member.entity.Member;
import com.attraction.modular.recommend.service.IRecommendService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/attraction")
public class AttractionController {
    @Autowired
    private IAttractionService attractionService;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IRecommendService recommendService;

    @RequestMapping("/detail")
    public ModelAndView detail(Integer id, HttpSession session,
                               ModelAndView mav) {
        Attraction attraction = attractionService.selectById(id);
        mav.addObject("attraction", attraction);
        Member member = (Member) session.getAttribute("member");
        mav.addObject("member", member);
        List<Comment> commentList = commentService.listComment(id);
        mav.addObject("commentList", commentList);
        mav.setViewName("/attraction/detail");
        return mav;
    }

//    @RequestMapping("/recommend")
//    @ResponseBody
//    public Object attractionRecommend(HttpSession session) {
//        try {
//            Object obj = attractionService.attractionRecommend();
//            return obj;
//        } catch (TasteException e) {
//            throw new CheckException(e.getMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @RequestMapping("/search")
    @ResponseBody
    public ReturnResult search(String keyword, HttpSession session) {
        List<Attraction> search = attractionService.search(keyword);
        Member member = (Member) session.getAttribute("member");
        if (null != member) {
            recommendService.updateUserAction(search, member.getId(), 1);
        }
        return ReturnResult.ok(search);
    }
}
