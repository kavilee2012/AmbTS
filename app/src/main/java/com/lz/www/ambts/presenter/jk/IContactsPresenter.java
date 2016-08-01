package com.lz.www.ambts.presenter.jk;

import android.widget.SimpleAdapter;

import com.lz.www.ambts.model.bean.Contacts;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-08-01.
 */
public interface IContactsPresenter extends IBasePresenter {

    void loadContactsList();

    void searchContactsList(String key);
}
