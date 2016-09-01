package com.lz.www.ambts.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016-09-01.
 */
public class ReportData extends Fa {
    @SerializedName("ID")
    int id;
    @SerializedName("YM")
    String ym;
    @SerializedName("Money")
    Float money;
}
