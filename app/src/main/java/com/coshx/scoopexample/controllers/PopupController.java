package com.coshx.scoopexample.controllers;

import android.app.Activity;
import android.util.Log;

import com.coshx.scoopexample.MainActivity;
import com.coshx.scoopexample.R;
import com.coshx.scoopexample.screens.AlertPopupScreen;
import com.coshx.scoopexample.screens.ConfirmPopupScreen;
import com.coshx.scoopexample.screens.InformPopupScreen;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ViewController;

import javax.inject.Inject;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * PopupController
 * <p/>
 */
public class PopupController extends ViewController {

    @Inject
    Activity activity;

    @Override
    protected int layoutId() {
        return R.layout.popup;
    }

    private void showPopup(String message, Style style) {
        Crouton.cancelAllCroutons();
        Crouton
            .makeText(activity, message, style)
            .show();
    }

    @Override
    public void onAttach() {
        super.onAttach();

        MainActivity.getActivityComponent().inject(this);

        Screen screen = Screen.fromController(this);
        if (screen instanceof InformPopupScreen) {
            showPopup(((InformPopupScreen) screen).message, Style.INFO);
        } else if (screen instanceof ConfirmPopupScreen) {
            showPopup(((ConfirmPopupScreen) screen).message, Style.CONFIRM);
        } else if (screen instanceof AlertPopupScreen) {
            showPopup(((AlertPopupScreen) screen).message, Style.ALERT);
        } else {
            Log.e(PopupController.class.getName(), "Invalid screen");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Crouton.cancelAllCroutons();
    }
}
