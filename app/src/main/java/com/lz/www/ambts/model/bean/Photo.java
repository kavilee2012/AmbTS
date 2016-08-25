package com.lz.www.ambts.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Administrator on 2016-08-24.
 */
public class Photo {
    @SerializedName("ID")
    public int ID;
    @SerializedName("Sort")
    public String Sort;
    @SerializedName("Url")
    public String Url;
    @SerializedName("ImgInfo")
    public String ImgInfo;
    @SerializedName("AddTime")
    public Date AddTime;
    @SerializedName("AddUser")
    public String AddUser;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        Sort = sort;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getImgInfo() {
        return ImgInfo;
    }

    public void setImgInfo(String imgInfo) {
        ImgInfo = imgInfo;
    }

    public Date getAddTime() {
        return AddTime;
    }

    public void setAddTime(Date addTime) {
        AddTime = addTime;
    }

    public String getAddUser() {
        return AddUser;
    }

    public void setAddUser(String addUser) {
        AddUser = addUser;
    }
}
