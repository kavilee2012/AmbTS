package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.Report;
import com.lz.www.ambts.model.bean.SBU;
import com.lz.www.ambts.model.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface ISbuService {

    @GET("sbu/getlist")
    Call<MyResponse<List<SBU>>> getAllList();
}
