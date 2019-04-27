package com.attraction.modular.feedback.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class Feedback implements Serializable {
    @Excel(name = "反馈ID")
    private Integer feedbackId;

    @Excel(name ="反馈标题")
    private String feedbackTitle;

//    @Excel(name = "反馈内容")
    private String feedbackContent;

    // 原冗余,现 提交对象
    @Excel(name = "提交对象")
    private String feedbackPictures;

    @Excel(name = "反馈状态",replace = {"未处理_0","处理中_1","已处理_2","技术人员最终回复_3","工作人员最终回复_4"})
    private Integer feedbackDone;

    @Excel(name = "提交时间")
    private String feedbackPushTime;

    @Excel(name = "完成时间")
    private String feedbackDoneTime;

    @Excel(name = "执行人")
    private Integer feedbackActiveMan;

    @Excel(name = "提交人")
    private Integer feedbackPushMan;

    private String activeManName;

    private String pushManName;

    public String getActiveManName() {
        return activeManName;
    }

    public void setActiveManName(String activeManName) {
        this.activeManName = activeManName;
    }

    public String getPushManName() {
        return pushManName;
    }

    public void setPushManName(String pushManName) {
        this.pushManName = pushManName;
    }

    private static final long serialVersionUID = 1L;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackTitle() {
        return feedbackTitle;
    }

    public void setFeedbackTitle(String feedbackTitle) {
        this.feedbackTitle = feedbackTitle == null ? null : feedbackTitle.trim();
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
    }

    public String getFeedbackPictures() {
        return feedbackPictures;
    }

    public void setFeedbackPictures(String feedbackPictures) {
        this.feedbackPictures = feedbackPictures == null ? null : feedbackPictures.trim();
    }

    public Integer getFeedbackDone() {
        return feedbackDone;
    }

    public void setFeedbackDone(Integer feedbackDone) {
        this.feedbackDone = feedbackDone;
    }

    public String getFeedbackPushTime() {
        return feedbackPushTime;
    }

    public void setFeedbackPushTime(String feedbackPushTime) {
        this.feedbackPushTime = feedbackPushTime;
    }

    public String getFeedbackDoneTime() {
        return feedbackDoneTime;
    }

    public void setFeedbackDoneTime(String feedbackDoneTime) {
        this.feedbackDoneTime = feedbackDoneTime;
    }

    public Integer getFeedbackActiveMan() {
        return feedbackActiveMan;
    }

    public void setFeedbackActiveMan(Integer feedbackActiveMan) {
        this.feedbackActiveMan = feedbackActiveMan;
    }

    public Integer getFeedbackPushMan() {
        return feedbackPushMan;
    }

    public void setFeedbackPushMan(Integer feedbackPushMan) {
        this.feedbackPushMan = feedbackPushMan;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", feedbackId=").append(feedbackId);
        sb.append(", feedbackTitle=").append(feedbackTitle);
        sb.append(", feedbackContent=").append(feedbackContent);
        sb.append(", feedbackPictures=").append(feedbackPictures);
        sb.append(", feedbackDone=").append(feedbackDone);
        sb.append(", feedbackPushTime=").append(feedbackPushTime);
        sb.append(", feedbackDoneTime=").append(feedbackDoneTime);
        sb.append(", feedbackActiveMan=").append(feedbackActiveMan);
        sb.append(", feedbackPushMan=").append(feedbackPushMan);
        sb.append("]");
        return sb.toString();
    }
}