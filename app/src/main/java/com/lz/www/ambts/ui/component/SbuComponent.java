package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.fragment.SbuFragment;
import com.lz.www.ambts.ui.module.SbuModule;

import dagger.Component;

/**
 * Created by Administrator on 2016-08-03.
 */
@Component(modules = SbuModule.class)
public interface SbuComponent {
    void inject(SbuFragment fragment);
}
