package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/7/31.
 */
public interface INewsService {

    @GET("news/getOne/?id={id}")
    Call<MyResponse<List<News>>> getOne(@Path("id") int id);

    @GET("news/getlist")
    Call<MyResponse<List<News>>> getList();




}
