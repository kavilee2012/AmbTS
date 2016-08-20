package com.lz.www.ambts.presenter.jk;

import com.lz.www.ambts.model.bean.User;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface IWoPresenter extends IBasePresenter {

    void loadUserInfo();

    void setHeadPhoto();

    void setUserName(User user);

    void setMobile(User user);

    void setPassword(User user);

    void setSex(User user);
}
