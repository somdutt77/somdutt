package com.example.api.API;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(getApplicationContext());
        new RetrofitClient();
//        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
