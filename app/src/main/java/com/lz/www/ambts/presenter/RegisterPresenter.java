package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.User;
import com.lz.www.ambts.model.jk.IUserModel;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.presenter.jk.IRegisterPresenter;
import com.lz.www.ambts.ui.jk.IRegisterView;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016-07-30.
 */
public class RegisterPresenter implements IRegisterPresenter {

    IRegisterView mRegisterView;
    IUserModel mUserModel;

    public RegisterPresenter(IRegisterView registerView,IUserModel userModel){
        mRegisterView=registerView;
        mUserModel=userModel;
    }

    @Override
    public void register(String code,String pwd,String mobile) {
        //mRegisterView.showLoading();
        mUserModel.addUser(code, pwd, mobile, new IUserModel.GetOneUserCallback() {
            @Override
            public void onSuccess() {
                mRegisterView.showSuccess();
            }

            @Override
            public void onFail() {
                mRegisterView.showFail();
            }
        });
    }

    @Override
    public void start() {

    }
}
