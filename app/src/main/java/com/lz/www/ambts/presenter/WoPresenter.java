package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.bean.User;
import com.lz.www.ambts.model.jk.IWoService;
import com.lz.www.ambts.presenter.jk.IWoPresenter;
import com.lz.www.ambts.ui.jk.IWoView;

/**
 * Created by Administrator on 2016-08-22.
 */
public class WoPresenter implements IWoPresenter {

    IWoView mView;
    IWoService mModel;

    public WoPresenter(IWoView mView, IWoService mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void loadUserInfo() {
        User user= new User();
        user.setUserCode("admin");
        user.setUserName("管理员");
        user.setMobile("158768574");
        user.setPassword("admin");

        mView.showLoginView(user);
    }

    @Override
    public void setHeadPhoto() {

    }

    @Override
    public void setUserName(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void setMobile(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void setPassword(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void setSex(User user) {
        mView.showLoginView(user);
    }

    @Override
    public void start() {
        loadUserInfo();
    }
}
