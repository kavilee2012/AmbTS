package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.bean.Contacts;

import java.util.List;

/**
 * Created by Administrator on 2016-08-01.
 */
public interface IContactsService {

    List<Contacts> getList();

    List<Contacts> search(String key);


}
