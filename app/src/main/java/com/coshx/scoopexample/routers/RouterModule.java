package com.coshx.scoopexample.routers;

import com.lyft.scoop.ScreenScooper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * RouterModule
 * <p/>
 */
@Module
public class RouterModule {
    @Provides
    @Singleton
    public AppRouter provideAppRouter() {
        return new AppRouter(new ScreenScooper());
    }
}
