package com.ezgidogan.parselearning;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {



    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("5qohkTfLyCZVcTYlbkVPPshSBggiEheAiBY4qNmq")
                .clientKey("4aEkO08EF8px23eElgB4OITdFHRy9ZAo8QemuSWd")
                .server("https://parseapi.back4app.com/")
                .build()

        );

}
}
