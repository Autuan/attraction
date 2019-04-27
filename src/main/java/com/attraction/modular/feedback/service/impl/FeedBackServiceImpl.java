package com.attraction.modular.feedback.service.impl;

import com.attraction.common.entity.EchartPieResult;
import com.attraction.common.util.WebUtil;
import com.attraction.modular.feedback.entity.Feedback;
import com.attraction.modular.feedback.mapper.FeedbackMapper;
import com.attraction.modular.feedback.service.IFeedBackService;
import com.attraction.modular.user.entity.User;
import com.attraction.modular.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class FeedBackServiceImpl implements IFeedBackService {
    // ---------------------- 自动注入 ----------------------
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Feedback> getFeedbackList(Integer page, Integer rows, Integer userId, Integer statusId) {
        List<Feedback> feedbacks =  feedbackMapper.getTheFeedbackList((page-1)*rows,rows,userId,statusId);
        feedbacks.forEach(item -> {
            String name = userService.getNameById(item.getFeedbackPushMan());
            item.setPushManName(name);
            name = userService.getNameById(item.getFeedbackActiveMan());
            item.setActiveManName(name);
        });
        return feedbacks;
    }

    // ---------------------- 业务逻辑 ----------------------

    @Override
    public void updateFeedback(Integer feedbackId, Integer userId, int status) {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(feedbackId);
        feedback.setFeedbackActiveMan(userId);
        feedback.setFeedbackDone(status);
        if (status == 2) {
            feedback.setFeedbackDoneTime(WebUtil.getCurrentTime());
        }
        feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    public void updateFeedback(Integer feedbackId, int status) {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(feedbackId);
        feedback.setFeedbackDone(status);
        if (status == 2) {
            feedback.setFeedbackDoneTime(WebUtil.getCurrentTime());
        }
        feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    public void updateFeedback(Integer feedbackId, int userId, String context,int doneStatus) {
        String time = WebUtil.getCurrentTime();
        String name = "<span class='greenClass'>" + userService.getNameById(userId) + "</span>";
        context = name + "   于  " + time + "  时,  回复: <br><br>"
                    + context;
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(feedbackId);
        feedback.setFeedbackContent(context);
        feedback.setFeedbackDone(doneStatus);

        feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    @Transactional
    public void insertFeedback(Feedback feedback) {
        Integer userId = feedback.getFeedbackPushMan();
        String time = WebUtil.getCurrentTime();
        String name = "<span class='greenClass'>" + userService.getNameById(userId) + "</span>";
        String context = name + "   于  " + time + "  时,  说: <br><br>"
                + feedback.getFeedbackContent();
        feedback.setFeedbackContent(context);
        feedback.setFeedbackPushTime(WebUtil.getCurrentTime());
        feedbackMapper.insertSelective(feedback);
    }


    @Override
    public void deleteFeedback(Integer feedbackId) {
        feedbackMapper.deleteByPrimaryKey(feedbackId);
    }

    @Override
    public List<Feedback> getFeedbackStatus() {
        return feedbackMapper.getFeedbackStatus();
    }



    @Override
    public int updateFeedback(Feedback feedback) {
        if ( null != feedback.getActiveManName() ) {
            User user = userService.getUserByName(feedback.getActiveManName());
            feedback.setFeedbackActiveMan(user.getUserId());
        }
        return feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    public Integer getCountFeedbackByDay(String theDay, String theEndDay) {
        return feedbackMapper.getCountFeedbackByDay(theDay,theEndDay);
    }

    @Override
    public List<EchartPieResult> countFeedbackGroupByStatusLastWeek(String startDay, String endDay) {
        return feedbackMapper.countFeedbackGroupByStatusLastWeek(startDay,endDay);
    }

    @Override
    public Map<String, Object> countAllFeedback() {
        return feedbackMapper.countAllFeedback();
    }

    @Override
    public Map<String, Object> countNotDoneFeedback() {
        return feedbackMapper.countNotDoneFeedback();
    }

    @Override
    public Map<String, Object> countFeedbackOnlyToday(String today) {
        return feedbackMapper.countFeedbackOnlyToday(today);
    }

    @Override
    public Map<String, Object> countNotDoneFeedbackOnlyToday(String today) {
        return feedbackMapper.countNotDoneFeedbackOnlyToday(today);
    }
}
