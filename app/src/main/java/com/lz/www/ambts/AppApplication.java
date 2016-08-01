package com.lz.www.ambts;

import android.app.Application;
import android.content.Context;

import com.lz.www.ambts.ui.component.DaggerRegisterComponent;
import com.lz.www.ambts.ui.component.RegisterComponent;
import com.lz.www.ambts.ui.module.RegisterModule;

/**
 * Created by Administrator on 2016-07-30.
 */
public class AppApplication extends Application {
    private AppComponent appComponent;
    private static Context context;

    public static AppApplication get(Context context){
        return (AppApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    //返回
    public static Context getContextObject(){
        return context;
    }
}
