package com.lz.www.ambts.ui.jk;

import com.lz.www.ambts.model.bean.User;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface IWoView {

    void showLoginView(User user);

    void showNoLoginView();

    void openSetHeadPhoto();

    void openSetUserName();

    void openSetMobile();

    void openSetPassword();

    void showSuccess(int type,String msg);

    void showFail(int type,String msg);

}
