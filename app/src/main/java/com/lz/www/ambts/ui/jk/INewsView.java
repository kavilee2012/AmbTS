package com.lz.www.ambts.ui.jk;

import com.lz.www.ambts.model.bean.News;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface INewsView extends IBaseView {

    void showTopImages();

    void showNewsList(ArrayList<News> list);

    void showLoading();

    void showLoadingError(String msg);


}
