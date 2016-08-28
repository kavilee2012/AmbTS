package com.lz.www.ambts.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.lz.www.ambts.R;
import com.lz.www.ambts.ui.adapter.FaVpAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Administrator on 2016-06-23.
 */
public class FaFragment extends Fragment {

    private ReportFragment fg1;
    private SbuFragment fg2;

    List<Fragment> fragmentList;
    List<String> titleList;

    private FragmentManager fm;

//    private RadioGroup mFaTabBar;
//    private RadioButton mTabReport;

    @InjectView(R.id.myTool)
    Toolbar toolbar;
    @InjectView(R.id.toolTvTitle)
    TextView toolTvTitle;

    FaVpAdapter faVpAdapter;
    @InjectView(R.id.tabFa)
    TabLayout tabFa;
    @InjectView(R.id.vpFa)
    ViewPager vpFa;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fa,container,false);
        ButterKnife.inject(this,view);

        toolTvTitle.setText("落地方法");


        fm=getActivity().getSupportFragmentManager();

        fg1=new ReportFragment();
        fg2=new SbuFragment();

        fragmentList=new ArrayList<>();
        fragmentList.add(fg1);
        fragmentList.add(fg2);

        titleList=new ArrayList<>();
        titleList.add("经营会计");
        titleList.add("组织划分");

         tabFa.setTabMode(TabLayout.MODE_FIXED);
        tabFa.addTab(tabFa.newTab().setText(titleList.get(0)));
        tabFa.addTab(tabFa.newTab().setText(titleList.get(1)));

        faVpAdapter=new FaVpAdapter(fm,titleList,fragmentList);
        vpFa.setAdapter(faVpAdapter);

        tabFa.setupWithViewPager(vpFa);

        return view;
    }

    private void hideAllFragment(FragmentTransaction ft){
        if(fg1!=null)ft.hide(fg1);
        if(fg2!=null)ft.hide(fg2);
    }

}
