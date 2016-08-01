package com.lz.www.ambts.presenter;

import android.widget.SimpleAdapter;

import com.lz.www.ambts.AppApplication;
import com.lz.www.ambts.model.bean.Contacts;
import com.lz.www.ambts.presenter.jk.IContactsPresenter;
import com.lz.www.ambts.provider.ContactsResolver;
import com.lz.www.ambts.ui.jk.IContactsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-08-01.
 */
public class ContactsPresenter implements IContactsPresenter {


    IContactsView contactsView;

    public ContactsPresenter(IContactsView view) {
        this.contactsView=view;
    }

    @Override
    public void start() {
        loadContactsList();
    }

    @Override
    public void loadContactsList() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Contacts> contactsArrayList = new ContactsResolver().getContacts(AppApplication.getContextObject());
        for (int i=0;i<contactsArrayList.size();i++){
            Map<String,String> items=new HashMap<String, String>();
            items.put("name",contactsArrayList.get(i).getName());
            items.put("number",contactsArrayList.get(i).getNumber());
            list.add(items);
        }
        if(list.size()==0){
            contactsView.showLoadFail();
        }else {
            contactsView.showContactsList(list);
        }


    }

    @Override
    public void searchContactsList(String key) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        contactsView.showContactsList(list);
    }
}
