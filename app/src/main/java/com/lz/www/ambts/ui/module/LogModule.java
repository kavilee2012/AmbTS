package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.LogModel;
import com.lz.www.ambts.model.jk.ILogService;
import com.lz.www.ambts.presenter.LogPresenter;
import com.lz.www.ambts.presenter.jk.ILogPresenter;
import com.lz.www.ambts.ui.AmbLogActivity;
import com.lz.www.ambts.ui.jk.ILogView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/8/2.
 */
@Module
public class LogModule {
    private AmbLogActivity activity;

    public LogModule(AmbLogActivity activity) {
        this.activity = activity;
    }

    @Provides
    ILogView provideActivity(){
        return activity;
    }

    @Provides
    ILogService provideModel(){
        return new LogModel();
    }

    @Provides
    ILogPresenter providePresenter(ILogView view,ILogService model){
        return new LogPresenter(view,model);
    }
}
