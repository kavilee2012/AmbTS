package com.lz.www.ambts.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.net.RegisterAsyncTask;
import com.lz.www.ambts.presenter.jk.IRegisterPresenter;
import com.lz.www.ambts.ui.component.DaggerRegisterComponent;
import com.lz.www.ambts.ui.jk.IRegisterView;
import com.lz.www.ambts.ui.module.RegisterModule;
import com.lz.www.ambts.util.Config;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by Administrator on 2016-05-24.
 */
public class RegisterActivity extends AppCompatActivity implements IRegisterView {

    @Inject
    IRegisterPresenter mRegisterPresenter;

    @InjectView(R.id.btnRegisterStart)
    Button btnRegister;
    @InjectView(R.id.btnRegisterLogin)
    Button btnLogin;
    @InjectView(R.id.pbRegister)
    ProgressBar mPB;
    @InjectView(R.id.etRegisterName)
    EditText tvName;
    @InjectView(R.id.etRegisterPassword)
    EditText tvPwd;
    @InjectView(R.id.etRegisterEmail)
    EditText tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.inject(this);

        //构建注射器并注入到当前activity
        DaggerRegisterComponent.builder()
                .registerModule(new RegisterModule(this))
                .build()
                .inject(this);

    }

    @OnClick({R.id.btnRegisterStart,R.id.btnRegisterLogin})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btnRegisterStart:

                String name= tvName.getText().toString();
                String pwd=tvPwd.getText().toString();
                String mobile=tvEmail.getText().toString();

                mRegisterPresenter.register(name,pwd,mobile);


                break;
            case R.id.btnRegisterLogin:
                Intent it=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(it);
                break;
            default:
                break;
        }
    }


    @Override
    public void setPresenter(Object presenter) {
       // mRegisterPresenter=(IRegisterPresenter) presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showSuccess() {
        Toast.makeText(RegisterActivity.this,"注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFail() {
        Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
    }
}
