package com.lz.www.ambts.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyResponse {

    @SerializedName("code")
    private String Code;
    @SerializedName("msg")
    private String Msg;
    @SerializedName("count")
    private String Count;
    @SerializedName("data")
    private List<News> List;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public List<News> getData() {
        return List;
    }

    public void setData(List<News> data) {
        this.List = data;
    }
}
