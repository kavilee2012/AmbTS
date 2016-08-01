package com.lz.www.ambts.ui.component;

import com.lz.www.ambts.ui.ContractsActivity;
import com.lz.www.ambts.ui.module.ContactsModule;

import dagger.Component;

/**
 * Created by Administrator on 2016-08-01.
 */
@Component(modules = ContactsModule.class)
public interface ContactsComponent {

    void inject(ContractsActivity activity);
}
