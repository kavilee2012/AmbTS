package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.ScheduleActivity;
import com.lz.www.ambts.ui.module.ScheduleModule;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/2.
 */
@Component(modules = ScheduleModule.class)
public interface ScheduleComponent {

    void inject(ScheduleActivity activity);
}
