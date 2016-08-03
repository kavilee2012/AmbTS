package com.lz.www.ambts.model.jk;

import android.graphics.Bitmap;

import com.lz.www.ambts.model.bean.User;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface IWoService {

    void getUser(int id);

    void updateUser(User user);

    void uploadPhoto(Bitmap img,int uid);
}
