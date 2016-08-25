package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016-07-29.
 */
public interface IUserService {

    @GET("user/getOne/")
    Call<MyResponse<User>> getOne(@Query("token") String token);

    @GET("user/getlist")
    Call<MyResponse<List<User>>> getList();

    @GET("user/login/")
    Call<MyResponse<String>> login(@Query("code") String code,@Query("pwd") String pwd);

    @POST("user/register")
    Call<MyResponse> add(@Query("code") String code,@Query("pwd") String pwd,@Query("mobile") String mobile);

}
