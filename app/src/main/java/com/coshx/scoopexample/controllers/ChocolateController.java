package com.coshx.scoopexample.controllers;

import com.coshx.scoopexample.R;
import com.coshx.scoopexample.ScoopExampleApplication;
import com.coshx.scoopexample.routers.PopupRouter;
import com.coshx.scoopexample.screens.AlertPopupScreen;
import com.coshx.scoopexample.screens.ConfirmPopupScreen;
import com.coshx.scoopexample.screens.InformPopupScreen;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ViewController;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ChocolateController
 * <p/>
 */
public class ChocolateController extends ViewController {

    @Inject
    PopupRouter popupRouter;

    @Override
    protected int layoutId() {
        return R.layout.chocolate;
    }

    @Override
    public void onAttach() {
        super.onAttach();

        ScoopExampleApplication.getApplicationComponent().inject(this);
        ButterKnife.bind(this, getView());
    }

    @OnClick(R.id.chocolate_button)
    public void onChocolateButtonClick() {
        List<Screen> messages = Arrays.asList(
            new AlertPopupScreen("Chocolate is soooo gooooood"),
            new ConfirmPopupScreen("OMG chocolate"),
            new InformPopupScreen("Nothing is better than chocolate")
        );
        int i = (int) Math.round(Math.random() * (messages.size() - 1));

        popupRouter.goTo(messages.get(i));
    }
}
