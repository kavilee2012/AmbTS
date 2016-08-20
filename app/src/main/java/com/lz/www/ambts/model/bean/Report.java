package com.lz.www.ambts.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016-08-03.
 */
public class Report extends Fa {

    @SerializedName("ID")
    int id;
//    @SerializedName("Code")
//    String code;
    @SerializedName("FatherCode")
    String fatherCode;
    @SerializedName("Level")
    int level;
    @SerializedName("Order")
    int order;
//    @SerializedName("Name")
//    String name;
    @SerializedName(("Remark"))
    String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }

    public String getFatherCode() {
        return fatherCode;
    }

    public void setFatherCode(String fatherCode) {
        this.fatherCode = fatherCode;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
