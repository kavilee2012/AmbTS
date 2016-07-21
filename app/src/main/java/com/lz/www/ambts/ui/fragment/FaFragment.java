package com.lz.www.ambts.ui.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lz.www.ambts.R;


/**
 * Created by Administrator on 2016-06-23.
 */
public class FaFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private ReportFragment fg1;
    private SbuFragment fg2;
    private FragmentManager fm;

    private RadioGroup mFaTabBar;
    private RadioButton mTabReport;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fa,container,false);
        fm=getFragmentManager();
        mFaTabBar=(RadioGroup)view.findViewById(R.id.faTopTab);
        mFaTabBar.setOnCheckedChangeListener(this);
        mTabReport=(RadioButton)view.findViewById(R.id.tabReport);
        mTabReport.setChecked(true);

        return view;
    }

    private void hideAllFragment(FragmentTransaction ft){
        if(fg1!=null)ft.hide(fg1);
        if(fg2!=null)ft.hide(fg2);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction ft = fm.beginTransaction();
        hideAllFragment(ft);
        switch (i) {
            case R.id.tabReport:
                if (fg1 == null) {
                    fg1 = new ReportFragment();
                    ft.add(R.id.faContent, fg1);
                } else {
                    ft.show(fg1);
                }
                break;
            case R.id.tabSub:
                if (fg2 == null) {
                    fg2 = new SbuFragment();
                    ft.add(R.id.faContent, fg2);
                } else {
                    ft.show(fg2);
                }
                break;
        }
        ft.commit();

    }
}
