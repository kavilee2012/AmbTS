package com.lz.www.ambts.model;

import java.util.Date;

/**
 * Created by Administrator on 2016-07-09.
 */
public class Schedule {
    private int id;
    private Date scheduleTime;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
