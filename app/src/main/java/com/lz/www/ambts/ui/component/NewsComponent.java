package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.fragment.DaoFragment;
import com.lz.www.ambts.ui.module.NewsModule;

import dagger.Component;

/**
 * Created by Administrator on 2016/7/31.
 */
@Component(modules = NewsModule.class)
public interface NewsComponent {
    void inject(DaoFragment fragment);
}
