package com.lz.www.ambts.ui;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import com.lz.www.ambts.R;
import com.lz.www.ambts.util.CommonUtils;
import com.lz.www.ambts.util.SPUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-07-09.
 */
public class ScheduleActivity extends Activity {

    CalendarView calendarView;
    TimePicker timePicker;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        calendarView=(CalendarView)findViewById(R.id.cvSchedule);
        timePicker=(TimePicker)findViewById(R.id.tpSchedule);
        editText=(EditText)findViewById(R.id.etSchedule);


        Button btnSave=(Button)findViewById(R.id.btnAcSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long date = calendarView.getDate();
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd ");
                String nowDate = f.format(date);
                String scheduleTime = nowDate + hour + ":" + minute + ":00";

                String scheduleContent = editText.getText().toString();

                SPUtils.put(ScheduleActivity.this, "ScheduleTime", scheduleTime);
                SPUtils.put(ScheduleActivity.this, "ScheduleContent", scheduleContent);




                //定时提醒
                Intent it=new Intent(ScheduleActivity.this,ScheduleViewActivity.class);
                it.putExtra("content",scheduleContent);

                PendingIntent pi=PendingIntent.getActivity(ScheduleActivity.this,0,it,0);

                AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

                long sTimes=0;
                try {
                    Date sTime= CommonUtils.ConverToDate(scheduleTime);
                    sTimes=sTime.getTime();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alarmManager.set(AlarmManager.RTC_WAKEUP,sTimes,pi);


                Toast.makeText(ScheduleActivity.this,"日程设置完成！"+scheduleTime, Toast.LENGTH_SHORT).show();

            }
        });

        Button btnCancel=(Button)findViewById(R.id.btnAcBack);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}
