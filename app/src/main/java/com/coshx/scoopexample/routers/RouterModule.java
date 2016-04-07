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
    public AppRouter provideAppRouter(BodyRouter bodyRouter, FooterRouter footerRouter) {
        return new AppRouter(bodyRouter, footerRouter);
    }

    @Provides
    @Singleton
    public PopupRouter providePopupRouter() {
        return new PopupRouter(new ScreenScooper());
    }

    @Provides
    @Singleton
    public FooterRouter provideFooterRouter() {
        return new FooterRouter(new ScreenScooper());
    }

    @Provides
    @Singleton
    public BodyRouter provideBodyRouter() {
        return new BodyRouter(new ScreenScooper());
    }
}
