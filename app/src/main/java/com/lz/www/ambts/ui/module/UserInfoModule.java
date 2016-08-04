package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.presenter.UserInfoPresenter;
import com.lz.www.ambts.presenter.jk.IUserInfoPresenter;
import com.lz.www.ambts.ui.UserInfoActivity;
import com.lz.www.ambts.ui.jk.IUserInfoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016-08-03.
 */
@Module
public class UserInfoModule {
    UserInfoActivity activity;

    public UserInfoModule(UserInfoActivity activity) {
        this.activity = activity;
    }

    @Provides
    IUserInfoView provideView(){
        return activity;
    }

    @Provides
    IUserInfoPresenter providePresenter(IUserInfoView view){
        return new UserInfoPresenter(view);
    }
}
