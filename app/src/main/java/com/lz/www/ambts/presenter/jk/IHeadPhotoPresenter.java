package com.lz.www.ambts.presenter.jk;

import android.graphics.Bitmap;

import com.lz.www.ambts.model.bean.User;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface IHeadPhotoPresenter extends IBasePresenter {

    void loadHeadPhoto();

    void uploadPhoto(Bitmap img,int uid);

}
