package com.coshx.scoopexample.screens;

import com.coshx.scoopexample.controllers.PopupController;
import com.lyft.scoop.Controller;
import com.lyft.scoop.Screen;

/**
 * AlertPopupScreen
 * <p/>
 */
@Controller(PopupController.class)
public class AlertPopupScreen extends Screen {
    public String message;

    public AlertPopupScreen(String message) {
        this.message = message;
    }
}
