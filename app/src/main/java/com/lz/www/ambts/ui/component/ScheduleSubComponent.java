package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.ScheduleSubActivity;
import com.lz.www.ambts.ui.module.ScheduleSubModule;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/2.
 */
@Component(modules = ScheduleSubModule.class)
public interface ScheduleSubComponent  {

    void inject(ScheduleSubActivity activity);
}
