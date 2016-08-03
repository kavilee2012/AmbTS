package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.AmbLogActivity;
import com.lz.www.ambts.ui.module.LogModule;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/2.
 */
@Component(modules = LogModule.class)
public interface LogComponent {
    void inject(AmbLogActivity activity);
}
