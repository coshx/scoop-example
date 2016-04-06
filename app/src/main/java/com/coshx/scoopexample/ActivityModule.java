package com.coshx.scoopexample;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * ActivityModule
 * <p/>
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return activity;
    }
}
