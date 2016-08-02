package com.lz.www.ambts.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import com.lz.www.ambts.AppApplication;
import com.lz.www.ambts.model.bean.Schedule;
import com.lz.www.ambts.model.jk.IScheduleService;
import com.lz.www.ambts.ui.ScheduleActivity;
import com.lz.www.ambts.util.SPUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ScheduleModel implements IScheduleService {

    @Override
    public Schedule getOne(int id) {
        return null;
    }

    @Override
    public List<Schedule> getList() {
        return null;
    }

    @Override
    public int add(Schedule schedule) {
        //SPUtils.put(AppApplication.getContextObject(), "Schedule",schedule);
        // SPUtils.put(ScheduleActivity.this, "ScheduleContent", schedule.getContent());

//        //定时提醒
//        Intent it=new Intent(ScheduleActivity.this,ScheduleSubActivity.class);
//        it.putExtra("content",scheduleContent);
//
//        PendingIntent pi=PendingIntent.getActivity(ScheduleActivity.this,0,it,0);
//
//        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
//        long sTimes=0;
//        try {
//            Date sTime= schedule.getScheduleTime();
//            sTimes=sTime.getTime();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        alarmManager.set(AlarmManager.RTC_WAKEUP,sTimes,pi);

        return 1;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
