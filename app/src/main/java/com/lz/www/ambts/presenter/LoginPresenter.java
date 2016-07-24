package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.jk.IUserModel;
import com.lz.www.ambts.presenter.jk.ILoginPresenter;
import com.lz.www.ambts.ui.jk.ILoginView;

/**
 * Created by Administrator on 2016/7/24.
 */
public class LoginPresenter implements ILoginPresenter {

    ILoginView mLoginView;
    IUserModel mUserModel;
    public LoginPresenter(ILoginView loginView) {
        mLoginView=loginView;
        mLoginView.setPresenter(this);
    }

    @Override
    public void login(String name, String pwd) {
        mLoginView.showLoading();
        mUserModel.getOneUser(name, pwd, new IUserModel.GetOneUserCallback() {
            @Override
            public void onSuccess() {
                mLoginView.showSuccess();
                mLoginView.hideLoading();
            }

            @Override
            public void onFail() {
                mLoginView.showFail();
                mLoginView.hideLoading();
            }
        });
    }

    @Override
    public void getLastLogin() {

    }

    @Override
    public void start() {

    }
}
