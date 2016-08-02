package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.ContactsModel;
import com.lz.www.ambts.model.UserModel;
import com.lz.www.ambts.model.jk.IContactsService;
import com.lz.www.ambts.presenter.ContactsPresenter;
import com.lz.www.ambts.presenter.RegisterPresenter;
import com.lz.www.ambts.presenter.jk.IContactsPresenter;
import com.lz.www.ambts.presenter.jk.IRegisterPresenter;
import com.lz.www.ambts.ui.ContractsActivity;
import com.lz.www.ambts.ui.RegisterActivity;
import com.lz.www.ambts.ui.jk.IContactsView;

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
    IContactsView provideContactsActivity() {
        return contractsActivity;
    }

    @Provides
    IContactsService provideContactsModel(){
        return new ContactsModel();
    }

    @Provides
    IContactsPresenter provideContactsPresenter(IContactsView view,IContactsService model){
        return new ContactsPresenter(view,model);
    }
}
