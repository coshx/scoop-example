package com.coshx.scoopexample.components;

import android.content.Context;
import android.util.AttributeSet;

import com.coshx.scoopexample.ScoopExampleApplication;
import com.coshx.scoopexample.routers.FooterRouter;
import com.lyft.scoop.RouteChange;
import com.lyft.scoop.UiContainer;

import javax.inject.Inject;

/**
 * FooterUiComponent
 * <p/>
 */
public class FooterUiContainer extends UiContainer {

    private FooterRouter.ScoopChangedObserver observer;

    @Inject
    FooterRouter footerRouter;

    public FooterUiContainer(Context context, AttributeSet attrs) {
        super(context, attrs);

        ScoopExampleApplication.getApplicationComponent().inject(this);
        observer = new FooterRouter.ScoopChangedObserver() {
            @Override
            public void onScoopChanged(RouteChange routeChange) {
                goTo(routeChange);
            }
        };
        footerRouter.observe(observer);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        footerRouter.stopObserving(observer);
    }
}
