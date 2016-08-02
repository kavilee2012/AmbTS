package com.lz.www.ambts.model;

import com.lz.www.ambts.AppApplication;
import com.lz.www.ambts.model.bean.Contacts;
import com.lz.www.ambts.model.jk.IContactsService;
import com.lz.www.ambts.provider.ContactsResolver;

import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
public class ContactsModel implements IContactsService {

    @Override
    public List<Contacts> getList() {
        return new ContactsResolver().getContacts(AppApplication.getContextObject());
    }

    @Override
    public List<Contacts> search(String key) {
        return null;
    }
}
