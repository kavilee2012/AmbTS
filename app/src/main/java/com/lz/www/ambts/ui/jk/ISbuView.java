package com.lz.www.ambts.ui.jk;

import com.lz.www.ambts.model.bean.SBU;
import com.lz.www.ambts.model.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface ISbuView {

    void showSbuList(List<SBU> groupList,List<User> subList);

    void showMemberInfo(int id);
}
