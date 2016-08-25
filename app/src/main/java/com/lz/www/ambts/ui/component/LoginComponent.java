package com.lz.www.ambts.ui.component;

import android.app.Activity;

import com.lz.www.ambts.ui.LoginActivity;
import com.lz.www.ambts.ui.module.LoginModule;
import com.lz.www.ambts.ui.module.NewsModule;

import dagger.Component;

/**
 * Created by Administrator on 2016-08-24.
 */
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
