package com.coshx.scoopexample;

import android.app.Application;

/**
 * ScoopExampleApplication
 * <p/>
 */
public class ScoopExampleApplication extends Application {
    private static ScoopExampleApplication instance;
    private        ApplicationComponent    applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        applicationComponent = DaggerApplicationComponent
            .builder()
            .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return instance.applicationComponent;
    }
}
