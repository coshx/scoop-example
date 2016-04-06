package com.coshx.scoopexample.screens;

import com.coshx.scoopexample.controllers.PopupController;
import com.lyft.scoop.Controller;
import com.lyft.scoop.Screen;

/**
 * ConfirmPopupScreen
 * <p/>
 */
@Controller(PopupController.class)
public class ConfirmPopupScreen extends Screen {
    public String message;

    public ConfirmPopupScreen(String message) {
        this.message = message;
    }
}
