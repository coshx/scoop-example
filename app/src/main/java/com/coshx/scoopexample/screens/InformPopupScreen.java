package com.coshx.scoopexample.screens;

import com.coshx.scoopexample.controllers.PopupController;
import com.lyft.scoop.Controller;
import com.lyft.scoop.Screen;

/**
 * InformPopupScreen
 * <p/>
 */
@Controller(PopupController.class)
public class InformPopupScreen extends Screen {
    public String message;

    public InformPopupScreen(String message) {
        this.message = message;
    }
}
