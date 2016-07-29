package com.lz.www.ambts.model.jk;

import android.graphics.Bitmap;

import com.lz.www.ambts.model.bean.News;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface INewsModel {

    void getNewsList(LoadNewsListCallback callback);

    ArrayList<Bitmap> getTopImages();

    interface LoadNewsListCallback {
        void onSuccess(ArrayList<News> list);
        void onFail(String msg);
    }
}
