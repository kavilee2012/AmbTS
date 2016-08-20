package com.lz.www.ambts.model.bean;

import com.google.gson.annotations.SerializedName;

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
    @SerializedName("PhotoID")
    public int PhotoID;
    @SerializedName("SbuCode")
    public String SbuCode;

    public String getSbuCode() {
        return SbuCode;
    }

    public void setSbuCode(String sbuCode) {
        SbuCode = sbuCode;
    }

    public int getPhotoID() {
        return PhotoID;
    }

    public void setPhotoID(int photoID) {
        PhotoID = photoID;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

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

    public String getSBU() {
        return SBU;
    }

    public void setSBU(String SBU) {
        this.SBU = SBU;
    }

    public String SBU;
}
