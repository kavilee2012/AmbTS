package com.lz.www.ambts.ui.jk;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface IHeadPhotoView {

    void showHeadPhoto(Bitmap img);

    void showTakePhoto();

    void showSelectPhoto();

    void showSuccess(String msg);

    void showFail(String msg);
}
