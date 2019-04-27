package com.attraction.modular.feedback.mapper;

import com.attraction.common.entity.EchartPieResult;
import com.attraction.modular.feedback.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer feedbackId);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer feedbackId);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    void updateActiveMan(Integer userId);

    void updatePushMan(Integer userId);

    List<Feedback> getFeedbackStatus();

    Integer getCountFeedbackByDay(@Param("startDay") String theDay,
                                  @Param("endDay") String theEndDay);

    List<EchartPieResult> countFeedbackGroupByStatusLastWeek(@Param("startDay") String startDay,
                                                       @Param("endDay") String endDay);

    Map<String,Object> countAllFeedback();

    Map<String,Object> countNotDoneFeedback();

    Map<String,Object> countFeedbackOnlyToday(String today);

    Map<String,Object> countNotDoneFeedbackOnlyToday(String today);

    List<Feedback> getTheFeedbackList(@Param("startRow") int startRow,
                                      @Param("rows") Integer rows,
                                      @Param("userId") Integer userId,
                                      @Param("statusId") Integer statusId);
}