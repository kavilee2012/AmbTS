package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.jk.INewsService;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.presenter.LoginPresenter;
import com.lz.www.ambts.presenter.jk.ILoginPresenter;
import com.lz.www.ambts.ui.LoginActivity;
import com.lz.www.ambts.ui.jk.ILoginView;
import com.lz.www.ambts.util.Config;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016-08-24.
 */
@Module
public class LoginModule {
    LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    ILoginView provideView(){
        return new LoginActivity();
    }

    @Provides
    IUserService provideModel(){
        return  new Retrofit.Builder()
                .baseUrl(Config.AMB_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IUserService.class);
    }

    @Provides
    ILoginPresenter providePresenter(ILoginView view,IUserService model){
        return new LoginPresenter(view,model);
    }

}
