package com.lz.www.ambts.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.lz.www.ambts.R;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.presenter.WoPresenter;
import com.lz.www.ambts.presenter.jk.IWoPresenter;
import com.lz.www.ambts.ui.fragment.DaoFragment;
import com.lz.www.ambts.ui.fragment.FaFragment;
import com.lz.www.ambts.ui.fragment.LunboFragment;
import com.lz.www.ambts.ui.fragment.ShuFragment;
import com.lz.www.ambts.ui.fragment.WoFragment;
import com.lz.www.ambts.util.Config;
import com.lz.www.ambts.util.SPUtils;

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

        fm=getSupportFragmentManager();
        _homeTabBar=(RadioGroup)findViewById(R.id.homeTabBar);
        _homeTabBar.setOnCheckedChangeListener(this);
        _itemDao=(RadioButton)findViewById(R.id.itemDAO);
        _itemDao.setChecked(true);

        //加载Token
        Config.AMB_TOKEN = String.valueOf(SPUtils.get(getApplicationContext(),"Token",""));
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

//    IUserService mUser;
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode){
//            case 111:
//                //登录返回
//                IWoPresenter woPresenter1=new WoPresenter(fg4,mUser);
//                woPresenter1.loadUserInfo();
//                break;
//            case 222:
//                //设置头像返回
//                IWoPresenter woPresenter2=new WoPresenter(fg4,mUser);
//                woPresenter2.loadUserInfo();
//                break;
//            default:
//                IntentResult scanResult= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
//                if(scanResult!=null) {
//                    String result = scanResult.getContents();
//                    if (result != null && result.toLowerCase().contains("http")) {
//                        Intent it = new Intent(this, NewsDetailActivity.class);
//                        it.putExtra("url", result);
//                        it.putExtra("title", "扫描结果");
//                        startActivity(it);
//                    } else {
////                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
//                    }
//                }
//                break;
//        }
//
//    }
}
