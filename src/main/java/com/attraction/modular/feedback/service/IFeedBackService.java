package com.attraction.modular.feedback.service;

import com.attraction.common.entity.EchartPieResult;
import com.attraction.modular.feedback.entity.Feedback;

import java.util.List;
import java.util.Map;

public interface IFeedBackService {
    /**
     * 获取反馈列表
     * @param page 页数
     * @param rows 行数
     * @param userId 提交人
     * @param statusId 状态
     * @return
     */
    List<Feedback> getFeedbackList(Integer page, Integer rows, Integer userId, Integer statusId);

    /**
     * 更新反馈信息
     * @param feedbackId 反馈id
     * @param userId 操作用户
     * @param status 状态
     */
    void updateFeedback(Integer feedbackId, Integer userId, int status);

    /**
     * 更新反馈信息
     * @param feedbackId 反馈id
     * @param status
     */
    void updateFeedback(Integer feedbackId, int status);

    /**
     * 更新反馈 主要用于反馈新回复的时候操作
     * @param feedbackId 反馈id
     * @param userId 操作人员
     * @param context 内容
     * @param doneStatus 操作状态
     */
    void updateFeedback(Integer feedbackId, int userId,String context,int doneStatus);

    /**
     * 添加新的反馈
     * @param feedback
     */
    void insertFeedback(Feedback feedback);

    /**
     * 删除反馈
     * @param feedbackId
     */
    void deleteFeedback(Integer feedbackId);

    /**
     * 获取状态
     * @return
     */
    List<Feedback> getFeedbackStatus();

    /**
     * 修改反馈
     * @param feedback
     * @return 修改成功的行数
     */
    int updateFeedback(Feedback feedback);

    /**
     * 根据日期统计期间反馈数量
     * @param theDay
     * @param theEndDay
     * @return
     */
    Integer getCountFeedbackByDay(String theDay, String theEndDay);

    /**
     * 统计最近一周反馈状态及数量
     * @param startDay
     * @param endDay
     * @return
     */
    List<EchartPieResult> countFeedbackGroupByStatusLastWeek(String startDay, String endDay);

    /**
     * 获取全部反馈数量
     * @return
     */
    Map<String,Object> countAllFeedback();

    /**
     * 获取全部未完成反馈数量
     * @return
     */
    Map<String,Object> countNotDoneFeedback();

    /**
     * 获取今日反馈数量
     * @return
     */
    Map<String,Object> countFeedbackOnlyToday(String today);

    /**
     * 获取今日未完成反馈数量
     * @return
     */
    Map<String,Object> countNotDoneFeedbackOnlyToday(String today);


}
