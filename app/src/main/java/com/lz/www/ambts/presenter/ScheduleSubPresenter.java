package com.lz.www.ambts.presenter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.Toast;
import com.lz.www.ambts.model.bean.Schedule;
import com.lz.www.ambts.model.jk.IScheduleService;
import com.lz.www.ambts.presenter.jk.IScheduleSubPresenter;
import com.lz.www.ambts.ui.ScheduleActivity;
import com.lz.www.ambts.ui.jk.IScheduleSubView;
import com.lz.www.ambts.util.SPUtils;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ScheduleSubPresenter implements IScheduleSubPresenter {
    IScheduleSubView scheduleSubView;
    IScheduleService scheduleModule;

    public ScheduleSubPresenter(IScheduleSubView scheduleSubView, IScheduleService scheduleService) {
        this.scheduleSubView = scheduleSubView;
        this.scheduleModule = scheduleService;
    }

    @Override
    public Schedule getSchedule(String key) {
        Schedule schedule=scheduleModule.getOne(key);
        return schedule;
    }

    @Override
    public void addSchedule(String key, Schedule schedule) {
        int re = scheduleModule.add(key,schedule);
        if(re>0) {
            scheduleSubView.showSetSuccess("添加成功！");
        }else{
            scheduleSubView.showSetFail("添加失败！");
        }
    }

    @Override
    public void deleteSchedule(String key) {
       int re = scheduleModule.delete(key);
        if(re>0) {
            scheduleSubView.showSetSuccess("删除成功！");
        }else{
            scheduleSubView.showSetFail("删除失败！");
        }
    }

    @Override
    public void start() {

    }
}
