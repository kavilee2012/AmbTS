package com.lz.www.ambts.model.jk;

import com.lz.www.ambts.model.bean.MyResponse;
import com.lz.www.ambts.model.bean.News;
import com.lz.www.ambts.model.bean.Report;
import com.lz.www.ambts.model.bean.ReportData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016-08-03.
 */
public interface IReportService {

    @GET("report/getlist")
   Call<MyResponse<List<Report>>> getAllList();
}
