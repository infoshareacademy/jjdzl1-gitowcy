package com.infoshare.academy.jjdzl1gitowcy;

import com.infoshare.academy.jjdzl1gitowcy.input.output.LogIn;
import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;

import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

import java.io.IOException;

/**
 * Project GITowcy Group!
 *
 */
public class App 
{
    public static void main(String[] args) {

        clearScreen();
//        Menu.showMainMenu();

        Menu.showLoginMenu();
    }
}
