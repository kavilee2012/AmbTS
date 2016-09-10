package com.lz.www.ambts.presenter.jk;

import com.lz.www.ambts.model.bean.Schedule;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface IScheduleSubPresenter extends IBasePresenter {

    Schedule getSchedule(String key);

    void addSchedule(String key, Schedule schedule);

    void deleteSchedule(String key);
}
