package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.model.jk.IUserService;
import com.lz.www.ambts.presenter.jk.IUserInfoPresenter;
import com.lz.www.ambts.ui.jk.IUserInfoView;

/**
 * Created by Administrator on 2016-08-03.
 */
public class UserInfoPresenter implements IUserInfoPresenter {
    IUserInfoView mView;
    IUserService mModel;

    public UserInfoPresenter(IUserInfoView mView) {
        this.mView = mView;
    }

    @Override
    public void loadUserInfo(int id) {
         mModel.getOne(String.valueOf(id));
    }

    @Override
    public void start() {

    }
}
