package com.dw.web.moudles.uart.entity;

import java.util.Date;

/**
 * 读取的卡号信息
 * 卡号
 * 开始时间
 * 结束时间
 */
public class UartVo {

    private int id;

    private Date startTime;

    private Date endTime;

    private  String stuCardId;
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
