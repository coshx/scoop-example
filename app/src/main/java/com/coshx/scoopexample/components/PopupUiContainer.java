package com.coshx.scoopexample.components;

import android.content.Context;
import android.util.AttributeSet;

import com.coshx.scoopexample.ScoopExampleApplication;
import com.coshx.scoopexample.routers.PopupRouter;
import com.lyft.scoop.RouteChange;
import com.lyft.scoop.UiContainer;

import javax.inject.Inject;

/**
 * PopupUiContainer
 * <p/>
 */
public class PopupUiContainer extends UiContainer {
    private PopupRouter.ScoopChangedObserver observer;

    @Inject
    PopupRouter popupRouter;

    public PopupUiContainer(Context context, AttributeSet attrs) {
        super(context, attrs);

        ScoopExampleApplication.getApplicationComponent().inject(this);
        observer = new PopupRouter.ScoopChangedObserver() {
            @Override
            public void onScoopChanged(RouteChange routeChange) {
                goTo(routeChange);
            }
        };
        popupRouter.observe(observer);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        popupRouter.stopObserving(observer);
    }
}
