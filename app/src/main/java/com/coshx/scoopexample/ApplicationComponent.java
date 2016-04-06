package com.coshx.scoopexample;

import com.coshx.scoopexample.components.BodyUiContainer;
import com.coshx.scoopexample.controllers.PistachioController;
import com.coshx.scoopexample.routers.RouterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ApplicationComponent
 * <p/>
 */
@Singleton
@Component(modules = {
    RouterModule.class
})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(PistachioController pistachioController);

    void inject(BodyUiContainer bodyUiContainer);
}
