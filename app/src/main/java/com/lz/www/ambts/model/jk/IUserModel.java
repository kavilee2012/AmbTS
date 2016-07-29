package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.User;

/**
 * Created by Administrator on 2016/7/24.
 */
public interface IUserModel {

    void getOneUser(String name, String pwd, GetOneUserCallback callback);

    void addUser(User user);

    void getUserList(GetUserListCallback callback);


    interface GetUserListCallback {
        void onSuccess();

        void onFail();
    }

    interface GetOneUserCallback {
        void onSuccess();

        void onFail();
    }


}
