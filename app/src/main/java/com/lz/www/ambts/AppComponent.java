package com.lz.www.ambts;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016-07-30.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Application getApplication();



}
