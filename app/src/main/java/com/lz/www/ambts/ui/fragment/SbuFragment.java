package com.lz.www.ambts.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.SBU;
import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.presenter.jk.ISbuPresenter;
import com.lz.www.ambts.ui.adapter.FaAdapter;
import com.lz.www.ambts.ui.component.DaggerReportComponent;
import com.lz.www.ambts.ui.component.DaggerSbuComponent;
import com.lz.www.ambts.ui.jk.ISbuView;
import com.lz.www.ambts.ui.module.ReportModule;
import com.lz.www.ambts.ui.module.SbuModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SbuFragment extends Fragment implements ISbuView {

    @Inject
    ISbuPresenter mPresenter;

    @InjectView(R.id.elvFa)
    ExpandableListView elvFa;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fa_sbu,container,false);

        ButterKnife.inject(getActivity());

        DaggerSbuComponent.builder()
                .sbuModule(new SbuModule(this))
                .build()
                .inject(this);

        mPresenter.start();

        elvFa.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
//                Toast.makeText(getActivity(), "你点击了：" + subListList.get(i).get(i1).getName(), Toast.LENGTH_SHORT).show();
                showMemberInfo(1);
                return true;
            }
        });
        return view;
    }

    @Override
    public void showSbuList(List<SBU> groupList, List<User> subList) {
//        FaAdapter faAdapter=new FaAdapter(groupList,subList,getActivity());
//        elvFa.setAdapter(faAdapter);
    }

    @Override
    public void showMemberInfo(int id) {
        new AlertDialog.Builder(getActivity())
                .setTitle("用户详细")
                .setMessage("........")
                .setPositiveButton("关闭",null)
                .show();
    }
}
