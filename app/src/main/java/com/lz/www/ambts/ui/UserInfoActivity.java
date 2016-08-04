package com.lz.www.ambts.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lz.www.ambts.AppComponent;
import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.presenter.jk.IUserInfoPresenter;
import com.lz.www.ambts.ui.jk.IUserInfoView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016-08-03.
 */
public class UserInfoActivity extends AppCompatActivity implements IUserInfoView {

    @Inject
    IUserInfoPresenter mPresenter;

    @InjectView(R.id.tvUserName)
    TextView tvName;
    @InjectView(R.id.tvMobile)
    TextView tvMobile;
    @InjectView(R.id.btnCall)
    Button btnCall;
    @InjectView(R.id.btnSendMsg)
    Button btnSendMsg;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_userinfo);
        ButterKnife.inject(this);

        mPresenter.start();
    }

    @OnClick({R.id.btnCall,R.id.btnSendMsg})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btnCall:

                break;
            case R.id.btnSendMsg:

                break;
        }
    }

    @Override
    public void showUserInfo(User user) {
        tvName.setText(user.getUserName());
        tvMobile.setText(user.getMobile());
    }
}
