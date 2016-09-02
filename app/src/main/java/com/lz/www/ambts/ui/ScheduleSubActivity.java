package com.lz.www.ambts.ui;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.Schedule;
import com.lz.www.ambts.presenter.jk.IScheduleSubPresenter;
import com.lz.www.ambts.ui.component.DaggerScheduleComponent;
import com.lz.www.ambts.ui.component.DaggerScheduleSubComponent;
import com.lz.www.ambts.ui.jk.IScheduleSubView;
import com.lz.www.ambts.ui.module.ScheduleModule;
import com.lz.www.ambts.ui.module.ScheduleSubModule;
import com.lz.www.ambts.util.CommonUtils;
import com.lz.www.ambts.util.SPUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Administrator on 2016-07-11.
 */
public class ScheduleSubActivity extends AppCompatActivity implements IScheduleSubView {

    @Inject
    IScheduleSubPresenter presenter;

    @InjectView(R.id.etSchedule)
    EditText etSchedule;
    @InjectView(R.id.dpSchedule)
    DatePicker datePicker;
    @InjectView(R.id.tpSchedule)
    TimePicker timePicker;

    @InjectView(R.id.myTool)
    Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_add,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedulesub);

        ButterKnife.inject(this);

        toolbar.setTitle("新建日程");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        DaggerScheduleSubComponent.builder()
                .scheduleSubModule(new ScheduleSubModule(this))
                .build()
                .inject(this);

        showAddView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAdd:
                saveSchedule();
                break;
            case R.id.menuDelete:
                int id=1;
                presenter.deleteSchedule(id);
                break;
        }
        return true;
    }

    private void saveSchedule(){

        long date = datePicker.getMaxDate();
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd ");
        String nowDate = f.format(date);
        String scheduleTime = nowDate + hour + ":" + minute + ":00";
        String scheduleContent = etSchedule.getText().toString();

        Schedule schedule=new Schedule();
        try {
             schedule.setScheduleTime(CommonUtils.ConverToDate(scheduleTime));
        }catch (Exception ex){ }
        schedule.setContent(scheduleContent);

        presenter.addSchedule(schedule);
    }

    @Override
    public void showAddView() {

    }

    @Override
    public void showInfoView() {
        String id = this.getIntent().getStringExtra("id");
        Schedule schedule=presenter.getSchedule(Integer.parseInt(id));
        etSchedule.setText(schedule.getContent());

    }

    @Override
    public void showSetSuccess(String msg) {
        Toast.makeText(ScheduleSubActivity.this,msg,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showSetFail(String msg) {
        Toast.makeText(ScheduleSubActivity.this,msg,Toast.LENGTH_SHORT).show();

    }
}
