package com.lz.www.ambts.ui.jk;

import com.lz.www.ambts.model.bean.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface IReportView {

    void showAllList(ArrayList<Report> groupList,ArrayList<ArrayList<Report>> subList);

}