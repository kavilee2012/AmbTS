package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.bean.Schedule;
import com.lz.www.ambts.model.jk.IScheduleService;
import com.lz.www.ambts.presenter.jk.ISchedulePresenter;
import com.lz.www.ambts.ui.jk.IScheduleView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class SchedulePresenter implements ISchedulePresenter {
    IScheduleView scheduleView;
    IScheduleService scheduleModel;

    public SchedulePresenter(IScheduleView scheduleView, IScheduleService scheduleModel) {
        this.scheduleView = scheduleView;
        this.scheduleModel = scheduleModel;
    }

    @Override
    public List<Schedule> getAllSchedule() {
        return null;
    }
}
