package com.lz.www.ambts.ui.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lz.www.ambts.model.NewsModel;
import com.lz.www.ambts.model.UserModel;
import com.lz.www.ambts.model.jk.INewsService;
import com.lz.www.ambts.presenter.NewsPresenter;
import com.lz.www.ambts.presenter.jk.INewsPresenter;
import com.lz.www.ambts.ui.component.DaggerNewsComponent;
import com.lz.www.ambts.ui.fragment.DaoFragment;
import com.lz.www.ambts.util.Config;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/7/31.
 */
@Module
public class NewsModule {

    DaoFragment daoFragment;
    public NewsModule(DaoFragment fragment) {
        daoFragment=fragment;
    }

    @Provides
    DaoFragment provideDaoFragment(){
        return daoFragment;
    }

    @Provides
    NewsModel provideNewsModel(){
        return new NewsModel();
    }

    @Provides
    INewsService provideNewsService(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

      return  new Retrofit.Builder()
              .baseUrl(Config.AMB_API)
              .addConverterFactory(GsonConverterFactory.create(gson))
              .build()
              .create(INewsService.class);
    }

    @Provides
    INewsPresenter provideNewsPresenter(DaoFragment fragment, INewsService newsService){
        return new NewsPresenter(fragment,newsService);
    }


}
