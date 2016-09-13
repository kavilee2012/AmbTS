package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.BigSorts;
import com.lz.www.ambts.model.SubSorts;
import com.lz.www.ambts.model.bean.Fa;
import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.bean.Report;
import com.lz.www.ambts.model.jk.IReportService;
import com.lz.www.ambts.presenter.jk.IReportPresenter;
import com.lz.www.ambts.ui.jk.IReportView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016-08-03.
 */
public class ReportPresenter implements IReportPresenter {

    IReportView mView;
    IReportService mModel;

    public ReportPresenter(IReportView view,IReportService model) {
        this.mView = view;
        this.mModel = model;
    }

    @Override
    public void loadAllList(String ym) {
      final ArrayList<Fa> groupList = new ArrayList<Fa>();
      final ArrayList<ArrayList<Fa>> itemList = new ArrayList<ArrayList<Fa>>();

        Call<MyResponse<List<Report>>> call = mModel.getAllList(ym);
        call.enqueue(new Callback<MyResponse<List<Report>>>() {
            @Override
            public void onResponse(Call<MyResponse<List<Report>>> call, Response<MyResponse<List<Report>>> response) {
                if (response.isSuccess()) {
                    ArrayList<Report> allList = (ArrayList<Report>) response.body().getData();
                    for (Report r : allList) {
                        if (r.getLevel() == 0) {
                            groupList.add(r);
                        }
                    }
                    for (Fa g : groupList) {
                        ArrayList<Fa> subList = new ArrayList<Fa>();
                        for (Report r : allList) {
                            if (r.getFatherCode().equals(g.getCode())) {
                                subList.add(r);
                            }
                        }
                        itemList.add(subList);
                    }
                    if (groupList.size() > 0) {
                        mView.showAllList(groupList, itemList);
                    } else {
                        mView.showLoadError();
                    }
                } else {
                    mView.showLoadError();
                }
            }

            @Override
            public void onFailure(Call<MyResponse<List<Report>>> call, Throwable t) {
                mView.showLoadError();
            }
        });







//
//        //数据准备
//        groupList = new ArrayList<Report>();
//        groupList.add(new BigSorts("收入"));
//        groupList.add(new BigSorts("费用"));
//        groupList.add(new BigSorts("利润"));
//
//        subListList = new ArrayList<ArrayList<SubSorts>>();
//
//        subList = new ArrayList<SubSorts>();
//
//        //收入组
//        subList.add(new SubSorts("001","A商品销售"));
//        subList.add(new SubSorts("002","B商品销售"));
//        subList.add(new SubSorts("003","C商品销售"));
//        subListList.add(subList);
//
//        //费用组
//        subList = new ArrayList<SubSorts>();
//        subList.add(new SubSorts("001","变动费用"));
//        subList.add(new SubSorts("002","固定费用"));
//        subList.add(new SubSorts("003","人工成本"));
//        subListList.add(subList);
//
//        //利润组
//        subList = new ArrayList<SubSorts>();
//        subList.add(new SubSorts("001","销售利润"));
//        subList.add(new SubSorts("002","节约利润"));
//        subList.add(new SubSorts("003","固定资产"));
//        subListList.add(subList);



    }

    @Override
    public void start() {
        loadAllList("201609");
    }
}
