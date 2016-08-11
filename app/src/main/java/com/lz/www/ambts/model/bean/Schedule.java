package com.lz.www.ambts.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Administrator on 2016-07-09.
 */
public class Schedule {

    @SerializedName("ID")
    private int id;
    @SerializedName("UserCode")
    private String userCode;
    @SerializedName("ScheduleTime")
    private Date scheduleTime;
    @SerializedName("Content")
    private String content;


    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

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
