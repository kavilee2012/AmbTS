package com.lz.www.ambts.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;


import com.lz.www.ambts.R;
import com.lz.www.ambts.model.BigSorts;
import com.lz.www.ambts.model.SubSorts;
import com.lz.www.ambts.model.bean.Report;
import com.lz.www.ambts.presenter.jk.IReportPresenter;
import com.lz.www.ambts.ui.adapter.FaAdapter;
import com.lz.www.ambts.ui.component.DaggerReportComponent;
import com.lz.www.ambts.ui.jk.IReportView;
import com.lz.www.ambts.ui.module.ReportModule;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016-06-23.
 */
public class ReportFragment extends Fragment implements IReportView {

    @Inject
    IReportPresenter mPresenter;

    @InjectView(R.id.elvFa)
    ExpandableListView elvFa;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fa_report,container,false);

        ButterKnife.inject(getActivity());
        DaggerReportComponent.builder()
                .reportModule(new ReportModule(this))
                .build()
                .inject(this);

        mPresenter.start();

        elvFa.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
//                Toast.makeText(getActivity(), "你点击了：" + subListList.get(i).get(i1).getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        return view;
    }

    @Override
    public void showAllList(ArrayList<Report> groupList, ArrayList<ArrayList<Report>> subList) {
        FaAdapter faAdapter=new FaAdapter(groupList,subList,getActivity());
        elvFa.setAdapter(faAdapter);
    }



}
