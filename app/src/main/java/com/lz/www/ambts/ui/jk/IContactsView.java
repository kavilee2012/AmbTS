package com.lz.www.ambts.ui.jk;

import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-08-01.
 */
public interface IContactsView {



    void showContactsList(List<Map<String, String>> list);


    void showLoadFail();


}
