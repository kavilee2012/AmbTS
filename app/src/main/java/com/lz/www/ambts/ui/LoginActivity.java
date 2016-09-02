package com.lz.www.ambts.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.presenter.LoginPresenter;
import com.lz.www.ambts.presenter.jk.ILoginPresenter;
import com.lz.www.ambts.ui.component.DaggerLoginComponent;
import com.lz.www.ambts.ui.component.DaggerSbuComponent;
import com.lz.www.ambts.ui.jk.ILoginView;
import com.lz.www.ambts.ui.module.LoginModule;
import com.lz.www.ambts.ui.module.SbuModule;
import com.lz.www.ambts.util.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {
    @Inject
    ILoginPresenter mLoginPresenter;

    @InjectView(R.id.myTool)
    Toolbar toolbar;

    @Inject
    IUserService mUserModel;

    @InjectView(R.id.login_progress)
    ProgressBar mProgressBar;
    @InjectView(R.id.btnLogin)
    Button btnLogin;
    @InjectView(R.id.etName)
    EditText etName;
    @InjectView(R.id.etPwd)
    EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);

        toolbar.setTitle("用户登录");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                mLoginPresenter.login(etName.getText().toString(),etPwd.getText().toString());
                String name = etName.getText().toString();
                String pwd = etPwd.getText().toString();
                Call<MyResponse<String>> call = mUserModel.login(name, pwd);
                call.enqueue(new Callback<MyResponse<String>>() {
                    @Override
                    public void onResponse(Call<MyResponse<String>> call, Response<MyResponse<String>> response) {
                        if (response.isSuccess()) {
                            String token = (String) response.body().getData();
                            Config.AMB_TOKEN = token;
                            showSuccess();
                        } else {
                            showFail();
                        }
                    }

                    @Override
                    public void onFailure(Call<MyResponse<String>> call, Throwable t) {
                        showFail();
                    }
                });
            }
        });

    }

    @Override
    public void showSuccess() {
        Toast.makeText(LoginActivity.this,"success",Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }


    @Override
    public void showFail() {
        Toast.makeText(this,"fail",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
       // mProgressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(ProgressBar.GONE);
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}

