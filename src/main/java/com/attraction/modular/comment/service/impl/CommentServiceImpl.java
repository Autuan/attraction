package com.attraction.modular.comment.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.attraction.modular.comment.entity.Comment;
import com.attraction.modular.comment.entity.CommentExample;
import com.attraction.modular.comment.mapper.CommentMapper;
import com.attraction.modular.comment.service.ICommentService;
import com.attraction.modular.recommend.service.IRecommendService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private IRecommendService recommendService;

    @Override
    public int comment(Comment comment) {
        if (null != comment.getId()) {
            return commentMapper.updateByPrimaryKey(comment);
        }
        int update = commentMapper.insertSelective(comment);
        int score;
        switch (comment.getType()) {
            case 1:
                score = 5;
                break;
            case 2:
                score = 3;
                break;
            case 3:
                score = 0;
                break;
            default:
                score = 1;
                break;
        }
        recommendService.updateAttraction(Arrays.asList(comment.getAttractionId()), comment.getMemberId(), score);
        return update;
    }

    @Override
    public List<Comment> listComment(Integer attractionId) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andAttractionIdEqualTo(attractionId);
        List<Comment> list = commentMapper.selectByExample(example);
        for (Comment comment : list) {
            String commentImg = comment.getCommentImg();
            if (StrUtil.isNotBlank(commentImg)) {
                String[] split = commentImg.split(",");
                List<String> imgList = Arrays.asList(split);
                comment.setImgList(imgList);
            }
        }
        return list;
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
        Comment comment = list.get(0);
        String commentImg = comment.getCommentImg();
        if (StrUtil.isNotBlank(commentImg)) {
            String[] split = commentImg.split(",");
            List<String> imgList = Arrays.asList(split);
            comment.setImgList(imgList);
        }
        return comment;
    }
}
