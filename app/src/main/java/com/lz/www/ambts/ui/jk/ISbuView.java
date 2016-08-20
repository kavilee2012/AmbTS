package com.lz.www.ambts.ui.jk;

import com.lz.www.ambts.model.bean.Fa;
import com.lz.www.ambts.model.bean.Report;
import com.lz.www.ambts.model.bean.SBU;
import com.lz.www.ambts.model.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface ISbuView {

    void showAllList(ArrayList<Fa> groupList, ArrayList<ArrayList<Fa>> subList);

    void showLoadError();
}
