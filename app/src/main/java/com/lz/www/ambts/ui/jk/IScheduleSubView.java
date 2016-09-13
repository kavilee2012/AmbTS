package com.lz.www.ambts.ui.jk;

import com.lz.www.ambts.model.bean.Schedule;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface IScheduleSubView {

    void showInfoView(Schedule schedule);

    void showSetSuccess(String msg);

    void showSetFail(String msg);
}
