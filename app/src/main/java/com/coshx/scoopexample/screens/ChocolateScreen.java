package com.coshx.scoopexample.screens;

import com.coshx.scoopexample.controllers.ChocolateController;
import com.lyft.scoop.Controller;
import com.lyft.scoop.EnterTransition;
import com.lyft.scoop.ExitTransition;
import com.lyft.scoop.Screen;
import com.lyft.scoop.transitions.FadeTransition;

/**
 * ChocolateScreen
 * <p/>
 */
@Controller(ChocolateController.class)
@EnterTransition(FadeTransition.class)
@ExitTransition(FadeTransition.class)
public class ChocolateScreen extends Screen {
}
