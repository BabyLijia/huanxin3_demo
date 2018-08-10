package com.example.asus.huanxin3_demo;

import android.app.Application;

import io.rong.imkit.RongIM;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);//初始化,然后记得在清单文件配置此类。
    }
}
