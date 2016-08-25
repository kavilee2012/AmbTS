package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.UserModel;
import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.jk.IUserModel;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.presenter.jk.ILoginPresenter;
import com.lz.www.ambts.ui.jk.ILoginView;
import com.lz.www.ambts.util.Config;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/7/24.
 */
public class LoginPresenter implements ILoginPresenter {

    ILoginView mLoginView;
    IUserService mUserModel;
    public LoginPresenter(ILoginView view,IUserService model) {
        mLoginView=view;
        mUserModel=model;
    }

    @Override
    public void login(String name, String pwd) {
        mLoginView.showSuccess();

        //        mUserModel.getOneUser(name, pwd, new IUserModel.GetOneUserCallback() {
//            @Override
//            public void onSuccess() {
//                mLoginView.showSuccess();
//                mLoginView.hideLoading();
//            }
//
//            @Override
//            public void onFail() {
//                mLoginView.showFail();
//                mLoginView.hideLoading();
//            }
//        });

//        Call<MyResponse<String>> call = mUserModel.login(name,pwd);
//        call.enqueue(new Callback<MyResponse<String>>() {
//            @Override
//            public void onResponse(Call<MyResponse<String>> call, Response<MyResponse<String>> response) {
//                if (response.isSuccess()) {
//                    String token = (String) response.body().getData();
//                    Config.AMB_TOKEN=token;
//                    mLoginView.showSuccess();
//                } else {
//                    mLoginView.showFail();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MyResponse<String>> call, Throwable t) {
//                mLoginView.showFail();
//            }
//        });

    }

    @Override
    public void start() {

    }
}
