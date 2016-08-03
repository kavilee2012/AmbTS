package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.ScheduleModel;
import com.lz.www.ambts.model.jk.IScheduleService;
import com.lz.www.ambts.presenter.SchedulePresenter;
import com.lz.www.ambts.presenter.ScheduleSubPresenter;
import com.lz.www.ambts.presenter.jk.ISchedulePresenter;
import com.lz.www.ambts.presenter.jk.IScheduleSubPresenter;
import com.lz.www.ambts.ui.ScheduleSubActivity;
import com.lz.www.ambts.ui.jk.IScheduleSubView;
import com.lz.www.ambts.ui.jk.IScheduleView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/8/2.
 */
@Module
public class ScheduleSubModule {
    private ScheduleSubActivity activity;

    public ScheduleSubModule(ScheduleSubActivity activity) {
        this.activity = activity;
    }

    @Provides
    IScheduleSubView provideActivity(){
        return activity;
    }

    @Provides
    IScheduleService provideModel(){
        return new ScheduleModel();
    }

    @Provides
    IScheduleSubPresenter providePresenter(IScheduleSubView view, IScheduleService model){
        return new ScheduleSubPresenter(view,model);
    }
}
