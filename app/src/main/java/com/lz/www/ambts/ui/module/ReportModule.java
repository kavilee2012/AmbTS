package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.jk.IReportService;
import com.lz.www.ambts.presenter.ReportPresenter;
import com.lz.www.ambts.presenter.jk.IReportPresenter;
import com.lz.www.ambts.ui.fragment.ReportFragment;
import com.lz.www.ambts.ui.jk.IReportView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016-08-03.
 */
@Module
public class ReportModule {

    ReportFragment fragment;

    public ReportModule(ReportFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    IReportView provideModel(){
        return fragment;
    }

    @Provides
    IReportPresenter providePresenter(IReportView view){
        return  new ReportPresenter(view);
    }
}
