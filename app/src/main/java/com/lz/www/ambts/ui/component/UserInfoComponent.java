package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.UserInfoActivity;
import com.lz.www.ambts.ui.module.UserInfoModule;

import dagger.Component;

/**
 * Created by Administrator on 2016-08-03.
 */
@Component(modules = UserInfoModule.class)
public interface UserInfoComponent {
    void inject(UserInfoActivity activity);
}
