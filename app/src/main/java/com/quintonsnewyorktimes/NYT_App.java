package com.quintonsnewyorktimes;

import android.app.Application;

import com.quintonsnewyorktimes.connection.AppComponent;
import com.quintonsnewyorktimes.connection.AppModule;
import com.quintonsnewyorktimes.connection.DaggerAppComponent;
import com.quintonsnewyorktimes.connection.NetWorkModule;

/**
 * Created by punit.shrirao on 13-03-2018.
 */

public class NYT_App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netWorkModule(new NetWorkModule())
                .build();

    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
}