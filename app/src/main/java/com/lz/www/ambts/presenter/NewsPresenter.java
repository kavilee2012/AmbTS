package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.NewsModel;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.jk.INewsModel;
import com.lz.www.ambts.presenter.jk.INewsPresenter;
import com.lz.www.ambts.ui.jk.INewsView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/23.
 */
public class NewsPresenter implements INewsPresenter {

    INewsView mNewsView;
    INewsModel mNewsModel;
    public NewsPresenter(INewsView newsView) {
        mNewsView=newsView;
        mNewsView.setPresenter(this);

        mNewsModel=new NewsModel();
    }

    @Override
    public void start() {
        loadNewsList();
    }

    @Override
    public void loadTopImages() {

    }

    @Override
    public void loadNewsList() {
         mNewsModel.getNewsList(new INewsModel.LoadNewsListCallback() {
           @Override
           public void onSuccess(ArrayList<News> list) {
               mNewsView.showNewsList(list);
           }

           @Override
           public void onFail(String msg) {
               mNewsView.showLoadingError(msg);
           }
       });
    }


}
