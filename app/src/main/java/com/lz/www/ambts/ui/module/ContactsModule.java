package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.UserModel;
import com.lz.www.ambts.presenter.ContactsPresenter;
import com.lz.www.ambts.presenter.RegisterPresenter;
import com.lz.www.ambts.presenter.jk.IContactsPresenter;
import com.lz.www.ambts.presenter.jk.IRegisterPresenter;
import com.lz.www.ambts.ui.ContractsActivity;
import com.lz.www.ambts.ui.RegisterActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016-08-01.
 */
@Module
public class ContactsModule {

    ContractsActivity contractsActivity;

    public ContactsModule(ContractsActivity contractsActivity) {
        this.contractsActivity = contractsActivity;
    }

    @Provides
    ContractsActivity provideContactsActivity() {
        return contractsActivity;
    }

    @Provides
    IContactsPresenter provideContactsPresenter(ContractsActivity activity){
        return new ContactsPresenter(activity);
    }
}
