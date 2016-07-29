package com.lz.www.ambts.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
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
import com.lz.www.ambts.presenter.LoginPresenter;
import com.lz.www.ambts.presenter.jk.ILoginPresenter;
import com.lz.www.ambts.ui.jk.ILoginView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {
    ILoginPresenter mLoginPresenter;
    ProgressBar mProgressBar;
    Button btnLogin;
    EditText etName;
    EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginPresenter=new LoginPresenter(this);
        mProgressBar =(ProgressBar)findViewById(R.id.login_progress);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        etName=(AutoCompleteTextView)findViewById(R.id.etName);
        etPwd=(EditText)findViewById(R.id.etPwd);

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login(etName.getText().toString(),etPwd.getText().toString());
            }
        });

    }

    @Override
    public void showSuccess() {
        Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFail() {
        Toast.makeText(this,"fail",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(ProgressBar.GONE);
    }

    @Override
    public void setPresenter(Object presenter) {
        mLoginPresenter=(ILoginPresenter) presenter;
    }
}

