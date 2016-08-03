package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.fragment.ReportFragment;
import com.lz.www.ambts.ui.module.ReportModule;

import dagger.Component;

/**
 * Created by Administrator on 2016-08-03.
 */
@Component(modules = ReportModule.class)
public interface ReportComponent {
    void inject(ReportFragment fragment);
}
