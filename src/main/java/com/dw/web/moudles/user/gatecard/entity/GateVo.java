package com.dw.web.moudles.user.gatecard.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 考勤统计实体类
 */
public class GateVo {

    /**
     * 当前登录人的id
     */
    private  String stuCardId;

    /**
     * 前端传过来的当天时间
     */
    /*@DateTimeFormat(pattern = "yyyy-MM-dd")*/
    private String gateTime;

    /**
     * 当天时间的00:00:00
     */
    private String starTime;

    /**
     * 当天时间的23:59:59
     */
    private String endTime;

    /**
     * 课程名称
     */
    private  String courseName;

    /**
     * 课程出勤次数
     */
    private String counts;

    /**
     *前端传过来的月数
     */
    private String gateMonth;

    public String getGateTime() {
        return gateTime;
    }

    public void setGateTime(String gateTime) {
        this.gateTime = gateTime;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStuCardId() {
        return stuCardId;
    }

    public void setStuCardId(String stuCardId) {
        this.stuCardId = stuCardId;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getGateMonth() {
        return gateMonth;
    }

    public void setGateMonth(String gateMonth) {
        this.gateMonth = gateMonth;
    }
}
