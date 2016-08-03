package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.presenter.ReportPresenter;
import com.lz.www.ambts.presenter.SbuPresenter;
import com.lz.www.ambts.presenter.jk.IReportPresenter;
import com.lz.www.ambts.presenter.jk.ISbuPresenter;
import com.lz.www.ambts.ui.fragment.ReportFragment;
import com.lz.www.ambts.ui.fragment.SbuFragment;
import com.lz.www.ambts.ui.jk.IReportView;
import com.lz.www.ambts.ui.jk.ISbuView;

import dagger.Module;
import dagger.Provides;

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
    ISbuPresenter providePresenter(ISbuView view){
        return new SbuPresenter(view);
    }
}
