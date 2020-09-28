package com.dw.web.moudles.user.attendance.entity;

import java.util.Date;

/**
 * 出勤实体类
 */
public class AttendanceVo {


    /**
     * 主键Id
     */
    private String id;

    private  String cardId;

    /**
     * 打卡开始时间
     */
    private Date startTime;

    /**
     * 打卡结束时间
     */
    private Date endTime;

    /**
     * 学生的cardId
     */
    private String stuCardId;

    /**
     * 学生的姓名
     */
    private String stuName;

    /**
     * 授课老师的Id
     */
    private String teaCardId;

    /**
     * 授课老师的姓名
     */
    private String teaName;

    /**
     * 课程科目
     */
    private String course;

    /**
     * 上课记录
     */
    private String content;

    /**
     * 班级信息
     */
    private String classInfo;

    /**
     * 手机号码
     */
    private String phone;

    private String identity;

    /**
     * 查询时间
     */
    private  String recorTime;

    private  String recordStarTime;

    private  String recordEndTime;

    /**
     * 请假人名称
     */
    private  String leaveName;

    /**
     * 编辑状态
     */
    private String editStatus;

    /**
     * 出勤人数
     */
    private String counts;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStuCardId() {
        return stuCardId;
    }

    public void setStuCardId(String stuCardId) {
        this.stuCardId = stuCardId;
    }

    public String getTeaCardId() {
        return teaCardId;
    }

    public void setTeaCardId(String teaCardId) {
        this.teaCardId = teaCardId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getRecorTime() {
        return recorTime;
    }

    public void setRecorTime(String recorTime) {
        this.recorTime = recorTime;
    }

    public String getRecordStarTime() {
        return recordStarTime;
    }

    public void setRecordStarTime(String recordStarTime) {
        this.recordStarTime = recordStarTime;
    }

    public String getRecordEndTime() {
        return recordEndTime;
    }

    public void setRecordEndTime(String recordEndTime) {
        this.recordEndTime = recordEndTime;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public String getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(String editStatus) {
        this.editStatus = editStatus;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }
}
