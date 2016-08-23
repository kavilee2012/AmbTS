package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.UserInfoActivity;
import com.lz.www.ambts.ui.fragment.WoFragment;
import com.lz.www.ambts.ui.module.WoModule;

import dagger.Component;
import dagger.Module;

/**
 * Created by Administrator on 2016-08-22.
 */
@Component(modules = WoModule.class)
public interface WoComponent {
    void inject(WoFragment fragment);
}
