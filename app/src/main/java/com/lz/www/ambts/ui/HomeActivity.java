package com.lz.www.ambts.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lz.www.ambts.R;
import com.lz.www.ambts.ui.fragment.DaoFragment;
import com.lz.www.ambts.ui.fragment.FaFragment;
import com.lz.www.ambts.ui.fragment.LunboFragment;
import com.lz.www.ambts.ui.fragment.ShuFragment;
import com.lz.www.ambts.ui.fragment.WoFragment;

public class HomeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private DaoFragment fg1;
    private FaFragment fg2;
    private ShuFragment fg3;
    private WoFragment fg4;
    private FragmentManager fm;


    private RadioGroup _homeTabBar;
    private RadioButton _itemDao;


    private void hideAllFragment(FragmentTransaction ft){
        if(fg1!=null)ft.hide(fg1);
        if(fg2!=null)ft.hide(fg2);
        if(fg3!=null)ft.hide(fg3);
        if(fg4!=null)ft.hide(fg4);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fm=getFragmentManager();
        _homeTabBar=(RadioGroup)findViewById(R.id.homeTabBar);
        _homeTabBar.setOnCheckedChangeListener(this);
        _itemDao=(RadioButton)findViewById(R.id.itemDAO);
        _itemDao.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction ft=fm.beginTransaction();
        hideAllFragment(ft);
        switch (checkedId){
            case R.id.itemDAO:
                //setTextNoSelected();
                //_tvDao.setSelected(true);
                if(fg1 == null){
                    fg1 = new DaoFragment();
                    ft.add(R.id.homeContent,fg1);
                }else{
                    ft.show(fg1);
                }
                break;
            case R.id.itemFA:
                if(fg2 == null){
                    fg2 = new FaFragment();
                    ft.add(R.id.homeContent,fg2);
                }else{
                    ft.show(fg2);
                }
                break;
            case R.id.itemSHU:
                if(fg3 == null){
                    fg3 = new ShuFragment();
                    ft.add(R.id.homeContent,fg3);
                }else{
                    ft.show(fg3);
                }
                break;
            case R.id.itemWO:
                if(fg4 == null){
                    fg4 = new WoFragment();
                    ft.add(R.id.homeContent,fg4);
                }else{
                    ft.show(fg4);
                }
                break;
        }
        ft.commit();
    }
}
