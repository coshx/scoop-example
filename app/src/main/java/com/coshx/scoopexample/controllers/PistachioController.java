package com.coshx.scoopexample.controllers;

import com.coshx.scoopexample.R;
import com.coshx.scoopexample.ScoopExampleApplication;
import com.coshx.scoopexample.routers.AppRouter;
import com.coshx.scoopexample.screens.ChocolateScreen;
import com.lyft.scoop.ViewController;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * PistachioController
 * <p/>
 */
public class PistachioController extends ViewController {

    @Inject
    AppRouter appRouter;

    @Override
    protected int layoutId() {
        return R.layout.pistachio;
    }

    @Override
    public void onAttach() {
        super.onAttach();

        ScoopExampleApplication.getApplicationComponent().inject(this);
        ButterKnife.bind(this, getView());
    }

    @OnClick(R.id.pistachio_button)
    public void onPistachioButtonClick() {
        appRouter.goTo(new ChocolateScreen());
    }
}
