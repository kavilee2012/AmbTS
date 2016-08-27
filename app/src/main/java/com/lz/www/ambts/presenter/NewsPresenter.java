package com.lz.www.ambts.presenter;

import android.widget.Toast;

import com.lz.www.ambts.model.NewsModel;
import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.jk.INewsModel;
import com.lz.www.ambts.model.jk.INewsService;
import com.lz.www.ambts.presenter.jk.INewsPresenter;
import com.lz.www.ambts.ui.jk.INewsView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/7/23.
 */
public class NewsPresenter implements INewsPresenter {

    INewsView mNewsView;
    INewsService mNewsService;
    public NewsPresenter(INewsView newsView,INewsService newsService) {
        mNewsView=newsView;
        mNewsService=newsService;
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
         Call<MyResponse<List<News>>> call = mNewsService.getList();
         call.enqueue(new Callback<MyResponse<List<News>>>() {
             @Override
             public void onResponse(Call<MyResponse<List<News>>> call, Response<MyResponse<List<News>>> response) {
                 if (response.isSuccess()) {
                     List<News> news = (List<News>)response.body().getData();
                     mNewsView.showNewsList(news);
                 } else {
                     mNewsView.showLoadingError("http fail");
                 }
             }

             @Override
             public void onFailure(Call<MyResponse<List<News>>> call, Throwable t) {
                 mNewsView.showLoadingError("http error");
             }
         });

//         mNewsModel.getNewsList(new INewsModel.LoadNewsListCallback() {
//           @Override
//           public void onSuccess(ArrayList<News> list) {
//               mNewsView.showNewsList(list);
//           }
//
//           @Override
//           public void onFail(String msg) {
//               mNewsView.showLoadingError(msg);
//           }
//       });
    }


}
