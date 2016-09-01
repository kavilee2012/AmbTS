package com.lz.www.ambts.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016-08-20.
 */
public class Fa {

    @SerializedName("Name")
    String name;

    @SerializedName("Code")
    String code;

    Float money;

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
