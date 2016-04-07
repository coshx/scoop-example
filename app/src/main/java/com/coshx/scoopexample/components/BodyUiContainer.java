package com.coshx.scoopexample.components;

import android.content.Context;
import android.util.AttributeSet;

import com.coshx.scoopexample.ScoopExampleApplication;
import com.coshx.scoopexample.routers.BodyRouter;
import com.lyft.scoop.RouteChange;
import com.lyft.scoop.UiContainer;

import javax.inject.Inject;

/**
 * BodyUiContainer
 * <p/>
 */
public class BodyUiContainer extends UiContainer {

    private BodyRouter.ScoopChangedObserver observer;

    @Inject
    BodyRouter bodyRouter;

    public BodyUiContainer(Context context, AttributeSet attrs) {
        super(context, attrs);

        ScoopExampleApplication.getApplicationComponent().inject(this);
        observer = new BodyRouter.ScoopChangedObserver() {
            @Override
            public void onScoopChanged(RouteChange routeChange) {
                goTo(routeChange);
            }
        };
        bodyRouter.observe(observer);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bodyRouter.stopObserving(observer);
    }
}
