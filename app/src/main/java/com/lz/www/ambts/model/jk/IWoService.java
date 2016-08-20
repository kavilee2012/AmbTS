package com.lz.www.ambts.model.jk;

import android.graphics.Bitmap;

import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface IWoService {

    @GET("user/getOne/?code={code}")
    Call<MyResponse<User>> getOne(@Path("code") String code);

    //void updateUser(User user);

    //void uploadPhoto(Bitmap img,int uid);
}
