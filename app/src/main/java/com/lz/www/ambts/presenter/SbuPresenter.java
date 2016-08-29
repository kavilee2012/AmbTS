package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.bean.Fa;
import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.Report;
import com.lz.www.ambts.model.bean.SBU;
import com.lz.www.ambts.model.jk.ISbuService;
import com.lz.www.ambts.presenter.jk.ISbuPresenter;
import com.lz.www.ambts.ui.jk.ISbuView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016-08-03.
 */
public class SbuPresenter implements ISbuPresenter {

    ISbuView mView;
    ISbuService mModel;

    public SbuPresenter(ISbuView view,ISbuService model) {
        this.mView=view;
        this.mModel=model;
    }

    @Override
    public void loadAllList() {
        final ArrayList<SBU> groupList = new ArrayList<SBU>();

        Call<MyResponse<List<SBU>>> call = mModel.getAllList();
        call.enqueue(new Callback<MyResponse<List<SBU>>>() {
            @Override
            public void onResponse(Call<MyResponse<List<SBU>>> call, Response<MyResponse<List<SBU>>> response) {
                if (response.isSuccess()) {
                    ArrayList<SBU> allList = (ArrayList<SBU>) response.body().getData();
                    for (SBU r : allList) {
                        if (r.getLevel() == 0) {
                            groupList.add(r);
                        }
                    }
//                    for (SBU g : groupList) {
//                        ArrayList<SBU> subList = new ArrayList<SBU>();
//                        for (SBU r : allList) {
//                            if (r.getFatherCode().equals(g.getCode())) {
//                                subList.add(r);
//                            }
//                        }
//                        itemList.add(subList);
//                    }
                    mView.showAllList(groupList);
                } else {
                    mView.showLoadError();
                }
            }

            @Override
            public void onFailure(Call<MyResponse<List<SBU>>> call, Throwable t) {
                mView.showLoadError();
            }
        });
    }

    @Override
    public void start() {
        loadAllList();
    }
}
