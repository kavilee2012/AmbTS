package com.lz.www.ambts.ui.jk;

import com.lz.www.ambts.model.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface INewsView {

    void showTopImages();

    void showNewsList(List<News> list);

    void showLoading();

    void showLoadingError(String msg);


}
