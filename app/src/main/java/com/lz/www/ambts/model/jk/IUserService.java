package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.bean.MyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016-07-29.
 */
public interface IUserService {

    @GET("users/{user}/repos")
    Call<MyResponse> getOne(@Path("user") String user);

    @GET("user/getlist")
    Call<MyResponse> getList();

    @GET("user/login")
    Call<MyResponse> login(@Query("code") String code,@Query("pwd") String pwd);

    @POST("user/register")
    Call<MyResponse> add(@Query("code") String code,@Query("pwd") String pwd,@Query("mobile") String mobile);

}
