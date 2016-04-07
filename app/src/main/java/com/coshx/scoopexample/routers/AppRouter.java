package com.coshx.scoopexample.routers;

import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Router;
import com.lyft.scoop.ScreenScooper;

import java.util.ArrayList;
import java.util.List;

/**
 * AppRouter
 * <p/>
 */
public class AppRouter extends Router {
    public interface ScoopChangedObserver {
        void onScoopChanged(RouteChange routeChange);
    }

    private List<ScoopChangedObserver> observers;

    public AppRouter(ScreenScooper screenScooper) {
        super(screenScooper);

        observers = new ArrayList<>();
    }

    @Override
    protected void onScoopChanged(RouteChange routeChange) {
        for (ScoopChangedObserver observer : observers) {
            observer.onScoopChanged(routeChange);
        }
    }

    public void observe(ScoopChangedObserver observer) {
        observers.add(observer);
    }

    public void stopObserving(ScoopChangedObserver observer) {
        observers.remove(observer);
    }
}
