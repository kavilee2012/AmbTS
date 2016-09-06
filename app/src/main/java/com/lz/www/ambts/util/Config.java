package com.lz.www.ambts.util;

import android.net.Uri;

import com.lz.www.ambts.model.bean.User;

/**
 * Created by Administrator on 2016-05-31.
 */
public class Config {

    public static String AMB_TOKEN = "";//"bc84e9369d40bc43dd01e9c78e77bbf8";//登录成功后获取
    public static User LoginUser = null; //登录用户信息

    public static final String AMB_IMG = "http://122.114.95.32/";
    public static final String AMB_API = "http://122.114.95.32/api/";
    public static final String UserAPI = AMB_API + "user/";
    public static final String NewsAPI = AMB_API + "news/";
    public static final String PhotoAPI = AMB_API + "photo/";


    public static final Uri AMBLOG_URI = Uri.parse("content://com.lz.www.ambrm.ContentProvider.LogProvider/AmbLog");



}
