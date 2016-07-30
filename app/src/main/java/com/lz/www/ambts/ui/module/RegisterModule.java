package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.UserModel;
import com.lz.www.ambts.model.jk.IUserModel;
import com.lz.www.ambts.presenter.RegisterPresenter;
import com.lz.www.ambts.presenter.jk.IRegisterPresenter;
import com.lz.www.ambts.ui.RegisterActivity;
import com.lz.www.ambts.ui.jk.IRegisterView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016-07-30.
 */
@Module
public class RegisterModule {

    private RegisterActivity registerActivity;


    public RegisterModule(RegisterActivity registerActivity) {
        this.registerActivity = registerActivity;
    }

    @Provides
    RegisterActivity provideRegisterActivity(){
        return registerActivity;
    }

    @Provides
    UserModel provideUserModel(){
        return new UserModel();
    }

    @Provides
    IRegisterPresenter provideRegisterPresenter(RegisterActivity registerActivity, UserModel userModel){
        return new RegisterPresenter(registerActivity,userModel);
    }
}
