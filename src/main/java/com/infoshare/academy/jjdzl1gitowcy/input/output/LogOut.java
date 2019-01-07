package com.infoshare.academy.jjdzl1gitowcy.input.output;

import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;
import com.infoshare.academy.jjdzl1gitowcy.quiz.InputKeys;

import java.util.concurrent.TimeUnit;

import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.*;
import static com.infoshare.academy.jjdzl1gitowcy.quiz.InputKeys.pressAnyKeyToContinue;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;
import static com.infoshare.academy.jjdzl1gitowcy.input.output.LogIn.userLoggedName;

public class LogOut {

    public static void outLog() {

        String inpUser = "";

        clearScreen();
        System.out.println("\nAre you sure you you want to log out?" +
                " If yes, press: Y");
        System.out.println("Press B to back the Menu");
        inpUser = InputKeys.inputStrings();
        System.out.println("Entered: " + inpUser);

        if (inpUser != null) {
            switch (inpUser) {

                case "y":
                    logoutProcedure();
                    break;
                case "Y":
                    logoutProcedure();
                    break;
                case "b":
                    clearScreen();
                    showMainMenu();
                    break;
                case "B":
                    clearScreen();
                    showMainMenu();
                    break;
                default: {
                    clearScreen();
                    System.out.println("Hmm, we don't have this choice. Try again...");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    outLog();
                }
            }
        }
    }

    private static void logoutProcedure() {

        String loggedOutInfo = "You are logged out! Wait a moment.";
        userLoggedName = null;
        isUserLogged = false;

        System.out.println(loggedOutInfo);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pressAnyKeyToContinue();
        clearScreen();
        showLoginMenu();
    }
}
