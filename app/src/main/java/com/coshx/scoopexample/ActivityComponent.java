package com.coshx.scoopexample;

import com.coshx.scoopexample.controllers.PopupController;

import dagger.Subcomponent;

/**
 * ActivityComponent
 * <p/>
 */
@Subcomponent(modules = {
    ActivityModule.class
})
public interface ActivityComponent {
    void inject(PopupController popupController);
}
