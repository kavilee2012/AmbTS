package com.lz.www.ambts.presenter.jk;

import com.lz.www.ambts.model.User;

/**
 * Created by Administrator on 2016/7/24.
 */
public interface ILoginPresenter extends IBasePresenter {

    void login(String name,String pwd);

    void getLastLogin();

}
