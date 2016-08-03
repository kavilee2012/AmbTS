package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.bean.SBU;
import com.lz.www.ambts.model.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface ISbuService {

    List<SBU> getSbuList();

    List<User> getUserList(int sbuID);

    User getUser(int uid);
}
