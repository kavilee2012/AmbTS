package com.lz.www.ambts.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;


import com.lz.www.ambts.R;
import com.lz.www.ambts.presenter.jk.ISchedulePresenter;
import com.lz.www.ambts.ui.component.DaggerScheduleComponent;
import com.lz.www.ambts.ui.jk.IScheduleView;
import com.lz.www.ambts.ui.module.ScheduleModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016-07-09.
 */
public class ScheduleActivity extends AppCompatActivity implements IScheduleView {

    @Inject
    ISchedulePresenter schedulePresenter;
    @InjectView(R.id.cvSchedule)
    CalendarView calendarView;

    @InjectView(R.id.myTool)
    Toolbar toolbar;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        ButterKnife.inject(this);

        toolbar.setTitle("日程安排");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        DaggerScheduleComponent.builder()
                .scheduleModule(new ScheduleModule(this))
                .build()
                .inject(this);

        showCalender();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showCalender();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:
                showSubView();
                break;
        }
        return true;
    }

    @Override
    public void showCalender() {
        schedulePresenter.getAllSchedule();
    }

    @Override
    public void showSubView() {
        Intent it = new Intent(ScheduleActivity.this, ScheduleSubActivity.class);
        startActivity(it);
    }
}
