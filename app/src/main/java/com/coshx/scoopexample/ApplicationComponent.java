package com.coshx.scoopexample;

import com.coshx.scoopexample.components.BodyUiContainer;
import com.coshx.scoopexample.components.FooterUiContainer;
import com.coshx.scoopexample.components.PopupUiContainer;
import com.coshx.scoopexample.controllers.ChocolateController;
import com.coshx.scoopexample.controllers.FooterController;
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
    ActivityComponent activityComponent(ActivityModule activityModule);

    void inject(MainActivity mainActivity);

    void inject(PistachioController pistachioController);

    void inject(ChocolateController chocolateController);

    void inject(FooterController footerController);

    void inject(BodyUiContainer bodyUiContainer);

    void inject(PopupUiContainer popupUiContainer);

    void inject(FooterUiContainer footerUiContainer);
}
