package com.attraction.modular.comment.controller;

import com.attraction.common.entity.ReturnResult;
import com.attraction.modular.base.service.IBaseService;
import com.attraction.modular.comment.entity.Comment;
import com.attraction.modular.comment.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IBaseService baseService;

    @RequestMapping("/addOrEdit")
    @ResponseBody
    public ReturnResult comment(Comment comment){
        int result = commentService.comment(comment);
        return result == 1 ? ReturnResult.ok() : ReturnResult.error();
    }

    @RequestMapping("/selectByMemberAndAttraction")
    @ResponseBody
    public ReturnResult selectByMemberAndAttraction(Integer memberId,Integer attractionId){
        baseService.checkParamNotNull(memberId,attractionId);
        Comment comment = commentService.selectByMemberAndAttraction(memberId, attractionId);
        return null == comment ? ReturnResult.error() : ReturnResult.ok(comment);
    }
}
