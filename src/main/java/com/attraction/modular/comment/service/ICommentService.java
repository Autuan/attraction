package com.attraction.modular.comment.service;

import com.attraction.modular.comment.entity.Comment;

import java.util.List;

public interface ICommentService {
    int comment(Comment comment);

    List<Comment> listComment(Integer attractionId);

    Comment selectByMemberAndAttraction(Integer memberId, Integer attractionId);
}
