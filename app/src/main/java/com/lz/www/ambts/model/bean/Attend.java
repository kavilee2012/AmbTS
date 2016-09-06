package com.lz.www.ambts.model.bean;

/**
 * Created by Administrator on 2016-09-06.
 */
public class Attend {
    public int ID;
    public String DateDisplay;
    public int ShouldDays;
    public int ActualDays;
    public int LateCount;
    public int LeaveCount;
    public int AbsentCount;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDateDisplay() {
        return DateDisplay;
    }

    public void setDateDisplay(String dateDisplay) {
        DateDisplay = dateDisplay;
    }

    public int getShouldDays() {
        return ShouldDays;
    }

    public void setShouldDays(int shouldDays) {
        ShouldDays = shouldDays;
    }

    public int getActualDays() {
        return ActualDays;
    }

    public void setActualDays(int actualDays) {
        ActualDays = actualDays;
    }

    public int getLateCount() {
        return LateCount;
    }

    public void setLateCount(int lateCount) {
        LateCount = lateCount;
    }

    public int getLeaveCount() {
        return LeaveCount;
    }

    public void setLeaveCount(int leaveCount) {
        LeaveCount = leaveCount;
    }

    public int getAbsentCount() {
        return AbsentCount;
    }

    public void setAbsentCount(int absentCount) {
        AbsentCount = absentCount;
    }
}
