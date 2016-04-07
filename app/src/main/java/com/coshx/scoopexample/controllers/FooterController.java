package com.coshx.scoopexample.controllers;

import com.coshx.scoopexample.R;
import com.coshx.scoopexample.ScoopExampleApplication;
import com.coshx.scoopexample.routers.AppRouter;
import com.coshx.scoopexample.screens.PineappleScreen;
import com.coshx.scoopexample.screens.PistachioScreen;
import com.coshx.scoopexample.screens.StrawberryScreen;
import com.lyft.scoop.ViewController;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * FooterController
 * <p/>
 */
public class FooterController extends ViewController {

    @Inject
    AppRouter appRouter;

    @Override
    protected int layoutId() {
        return R.layout.footer;
    }

    @Override
    public void onAttach() {
        super.onAttach();

        ScoopExampleApplication.getApplicationComponent().inject(this);
        ButterKnife.bind(this, getView());
    }

    @OnClick(R.id.footer_pistachio)
    public void onPistachio() {
        appRouter.goTo(new PistachioScreen());
    }

    @OnClick(R.id.footer_strawberry)
    public void onStrawberry() {
        appRouter.goTo(new StrawberryScreen());
    }

    @OnClick(R.id.footer_pineapple)
    public void onPineapple() {
        appRouter.goTo(new PineappleScreen());
    }
}
