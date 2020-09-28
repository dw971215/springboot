package com.dw.web.moudles.user.leavemanagement.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LeaveVo {

    private String id;
    /**
     * 申请人的cardId
     */
    private String applyCardId;

    /**
     * 申请人的姓名
     */
    private String leaveName;

    /**
     * 请假开始时间
     */
    private Date startTime;

    /**
     * 请假结束时间
     */
    private Date endTime;

    /**
     * 审批者Id
     */
    private String approverCardId;

    /**
     * 审核者姓名
     */
    private String approverName;
    /**
     * 请假理由
     */
    private String reason;

    /**
     * 状态
     */
    private String status;

    /**
     * 申请时间
     */
    private  Date addTime;

    /**
     * 审核时间
     */
    private Date verifyTime;

    /**
     * 所在班级
     */
    private String classInfo;
    /**
     * 当前登录人的Id
     */
    private String cardId;

    /**
     * 查询请假栏时间
     */
    private  String recorTime;

    /**
     * 请假栏开始时间
     */
    private String recorStarTime;

    /**
     * 请假栏结束时间
     */
    private String recorEndTime;

    /**
     *学生请假开始时间
     */
    private String stuStarTime;
    /**
     * 学生请假结束时间
     */
    private String stuEndTime;

    /**
     * 周几时间
     */
    private  String timeWeek;

    /**
     *每天学习时间统计
     */
    private  String timeCounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplyCardId() {
        return applyCardId;
    }

    public void setApplyCardId(String applyCardId) {
        this.applyCardId = applyCardId;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getApproverCardId() {
        return approverCardId;
    }

    public void setApproverCardId(String approverCardId) {
        this.approverCardId = approverCardId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getRecorTime() {
        return recorTime;
    }

    public void setRecorTime(String recorTime) {
        this.recorTime = recorTime;
    }

    public String getRecorStarTime() {
        return recorStarTime;
    }

    public void setRecorStarTime(String recorStarTime) {
        this.recorStarTime = recorStarTime;
    }

    public String getRecorEndTime() {
        return recorEndTime;
    }

    public void setRecorEndTime(String recorEndTime) {
        this.recorEndTime = recorEndTime;
    }

    public String getStuStarTime() {
        return stuStarTime;
    }

    public void setStuStarTime(String stuStarTime) {
        this.stuStarTime = stuStarTime;
    }

    public String getStuEndTime() {
        return stuEndTime;
    }

    public void setStuEndTime(String stuEndTime) {
        this.stuEndTime = stuEndTime;
    }

    public String getTimeWeek() {
        return timeWeek;
    }

    public void setTimeWeek(String timeWeek) {
        this.timeWeek = timeWeek;
    }

    public String getTimeCounts() {
        return timeCounts;
    }

    public void setTimeCounts(String timeCounts) {
        this.timeCounts = timeCounts;
    }
}
