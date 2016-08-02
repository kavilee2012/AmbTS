package com.lz.www.ambts.presenter.jk;

import com.lz.www.ambts.model.bean.Schedule;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface IScheduleSubPresenter {

    Schedule getSchedule(int id);

    void addSchedule(Schedule schedule);

    void deleteSchedule(int id);
}
