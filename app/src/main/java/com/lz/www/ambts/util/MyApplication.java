package com.lz.www.ambts.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016-06-01.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
