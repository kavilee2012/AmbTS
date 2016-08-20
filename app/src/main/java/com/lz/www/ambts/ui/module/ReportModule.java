package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.jk.INewsService;
import com.lz.www.ambts.model.jk.IReportService;
import com.lz.www.ambts.presenter.ReportPresenter;
import com.lz.www.ambts.presenter.jk.IReportPresenter;
import com.lz.www.ambts.ui.fragment.ReportFragment;
import com.lz.www.ambts.ui.jk.IReportView;
import com.lz.www.ambts.util.Config;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    IReportService provideReportService(){
        return  new Retrofit.Builder()
                .baseUrl(Config.AMB_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IReportService.class);
    }

    @Provides
    IReportPresenter providePresenter(IReportView view,IReportService model){
        return  new ReportPresenter(view,model);
    }
}
