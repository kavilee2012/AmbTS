package com.lz.www.ambts.model;

/**
 * Created by Administrator on 2016-06-12.
 */
public class SubSorts {
    private String code;
    private String name;
    private String url;

    public String getUrl() {
        return url;
    }

    public SubSorts(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
