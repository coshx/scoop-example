package com.coshx.scoopexample.routers;

import com.coshx.scoopexample.screens.ShowFooterScreen;
import com.lyft.scoop.Screen;

/**
 * AppRouter
 * <p/>
 */
public class AppRouter {
    private BodyRouter   bodyRouter;
    private FooterRouter footerRouter;

    AppRouter(BodyRouter bodyRouter, FooterRouter footerRouter) {
        this.bodyRouter = bodyRouter;
        this.footerRouter = footerRouter;
    }

    public void goTo(Screen screen) {
        bodyRouter.goTo(screen);

        // Trigger footer's screen here if needed (e.g for updating footer)
        if (!footerRouter.hasActiveScreen()) {
            footerRouter.goTo(new ShowFooterScreen());
        }
    }

    public boolean hasActiveScreen() {
        return bodyRouter.hasActiveScreen();
    }

    public boolean goBack() {
        footerRouter.goBack();
        return bodyRouter.goBack();
    }
}
