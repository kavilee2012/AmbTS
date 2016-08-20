package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.jk.IReportService;
import com.lz.www.ambts.model.jk.ISbuService;
import com.lz.www.ambts.presenter.ReportPresenter;
import com.lz.www.ambts.presenter.SbuPresenter;
import com.lz.www.ambts.presenter.jk.IReportPresenter;
import com.lz.www.ambts.presenter.jk.ISbuPresenter;
import com.lz.www.ambts.ui.fragment.ReportFragment;
import com.lz.www.ambts.ui.fragment.SbuFragment;
import com.lz.www.ambts.ui.jk.IReportView;
import com.lz.www.ambts.ui.jk.ISbuView;
import com.lz.www.ambts.util.Config;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016-08-03.
 */
@Module
public class SbuModule {

    SbuFragment fragment;

    public SbuModule(SbuFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    ISbuView provideModel(){
        return fragment;
    }

    @Provides
    ISbuService provideSbuService(){
        return  new Retrofit.Builder()
                .baseUrl(Config.AMB_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ISbuService.class);
    }

    @Provides
    ISbuPresenter providePresenter(ISbuView view,ISbuService model){
        return new SbuPresenter(view,model);
    }
}
