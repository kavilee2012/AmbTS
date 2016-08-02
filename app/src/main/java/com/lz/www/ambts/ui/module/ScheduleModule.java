package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.ScheduleModel;
import com.lz.www.ambts.model.jk.IScheduleService;
import com.lz.www.ambts.presenter.SchedulePresenter;
import com.lz.www.ambts.presenter.jk.ISchedulePresenter;
import com.lz.www.ambts.ui.ScheduleActivity;
import com.lz.www.ambts.ui.jk.IScheduleView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/8/2.
 */
@Module
public class ScheduleModule {
    private ScheduleActivity activity;

    public ScheduleModule(ScheduleActivity activity) {
        this.activity = activity;
    }

    @Provides
    IScheduleView provideActivity(){
        return activity;
    }

    @Provides
    IScheduleService provideModel(){
        return new ScheduleModel();
    }

    @Provides
    ISchedulePresenter providePresenter(IScheduleView view, IScheduleService model){
        return new SchedulePresenter(view,model);
    }
}
