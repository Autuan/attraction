package com.attraction.modular.comment.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.attraction.modular.comment.entity.Comment;
import com.attraction.modular.comment.entity.CommentExample;
import com.attraction.modular.comment.mapper.CommentMapper;
import com.attraction.modular.comment.service.ICommentService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int comment(Comment comment) {
        if(null != comment.getId()) {
            return commentMapper.updateByPrimaryKey(comment);
        }
        return commentMapper.insertSelective(comment);
    }

    @Override
    public List<Comment> listComment(Integer attractionId) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andAttractionIdEqualTo(attractionId);
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment selectByMemberAndAttraction(Integer memberId, Integer attractionId) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andMemberIdEqualTo(memberId)
                .andAttractionIdEqualTo(attractionId);
        List<Comment> list = commentMapper.selectByExample(example);
        if (CollUtil.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
