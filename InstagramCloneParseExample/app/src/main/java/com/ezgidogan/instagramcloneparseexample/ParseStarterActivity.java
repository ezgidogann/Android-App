package com.ezgidogan.instagramcloneparseexample;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("AGQ22PgbrIRuujVchdfSRdCh0ed3ePTjFRQRFlU0")
        .clientKey("ZgITcMhtUJUN6yhWIk9y40SJz0hhPwNVw26l0m68")
        .server("https://parseapi.back4app.com/")
        .build()
        );
    }
}
