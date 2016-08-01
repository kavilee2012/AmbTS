package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.AppComponent;
import com.lz.www.ambts.ui.RegisterActivity;
import com.lz.www.ambts.ui.module.RegisterModule;

import dagger.Component;

/**
 * Created by Administrator on 2016-07-30.
 */
@Component(modules = RegisterModule.class)
public interface RegisterComponent {
    void inject(RegisterActivity registerActivity);
}
