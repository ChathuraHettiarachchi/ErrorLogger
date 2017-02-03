package com.chootdev.sample;

import android.app.Application;

import com.chootdev.errorlogger.ErrorLogger;

/**
 * Created by Choota on 2/3/17.
 */

public class ApplicationSample extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ErrorLogger.init(this);
    }
}
