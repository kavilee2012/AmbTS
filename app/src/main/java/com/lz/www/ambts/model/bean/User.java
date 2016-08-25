package com.lz.www.ambts.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/31.
 */
public class User {

    @SerializedName("ID")
    public int ID ;
    @SerializedName("UserCode")
    public String UserCode;
    @SerializedName("UserName")
    public String UserName;
    @SerializedName("Password")
    public String Password;
    @SerializedName("Mobile")
    public String Mobile;
    @SerializedName("Sex")
    public boolean Sex;
    @SerializedName("BirthDay")
    public Date BirthDay;
    @SerializedName("Sbu")
    public SBU Sbu;
    @SerializedName("Photo")
    public Photo Photo;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }

    public SBU getSbu() {
        return Sbu;
    }

    public void setSbu(SBU sbu) {
        Sbu = sbu;
    }

    public com.lz.www.ambts.model.bean.Photo getPhoto() {
        return Photo;
    }

    public void setPhoto(com.lz.www.ambts.model.bean.Photo photo) {
        Photo = photo;
    }
}
