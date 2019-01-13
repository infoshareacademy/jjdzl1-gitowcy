package com.infoshare.academy.jjdzl1gitowcy.user_controller;

import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;
import com.infoshare.academy.jjdzl1gitowcy.quiz.InputKeys;

import java.util.concurrent.TimeUnit;

import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.isUserLogged;
import static com.infoshare.academy.jjdzl1gitowcy.quiz.InputKeys.inputStrings;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;
import static com.infoshare.academy.jjdzl1gitowcy.user_controller.InputFile.getFromFile;

//import static com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice.userName;

public class LogIn {

public static String userLoggedName;

    public static void run() {

        Boolean isLoginOK = false;
        String inpUser = null;
        int logCounter = 1;
        int logProof = 3;
        Boolean checkUser = false;
        String[] userData = null;
        String logProofDesc = "Login proof No.";
        String logProof2 = "failed. Left only";
        String logProof3 = "attempt";

        while (!isLoginOK && logCounter <= logProof) {

            System.out.print("\nEnter login: ");
            inpUser = inputStrings();

            if (getFromFile(inpUser) != null) {
                checkUser = true;
            } else {
                checkUser = false;
                if ((logProof - logCounter) > 1) {
                    System.out.printf("Invalid user name! %n %s %s %s %s %ss!",
                            logProofDesc, logCounter, logProof2, (logProof - logCounter), logProof3);
                } else if ((logProof - logCounter) == 1) {
                    System.out.printf("Invalid user name! %n %s %s %s %s %s!",
                            logProofDesc, logCounter, logProof2, (logProof - logCounter), logProof3);
                }
                logCounter++;
            }

            if (checkUser) {

                userData = getFromFile(inpUser);
                System.out.print("\nEnter password: ");
                String inputPass = inputStrings();

                if (inputPass.equals(userData[1])) {
                    clearScreen();
                    System.out.printf("Hello %s. You've logged in successfully! %n\n", inpUser);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    isLoginOK = true;
                    clearScreen();
                    userLoggedName = userData[0];
                    isUserLogged=true;
                } else {
                    if ((logProof - logCounter) > 1) {
                        System.out.printf("Invalid Password! %n %s %s %s %s %s!",
                                logProofDesc, logCounter, logProof2, (logProof - logCounter), logProof3);
                    } else if ((logProof - logCounter) == 1) {
                        System.out.printf("Invalid Password! %n %s %s %s %s %s!",
                                logProofDesc, logCounter, logProof2, (logProof - logCounter), logProof3);
                    }
                    logCounter++;
                }
            }
        }
        if ((logProof - logCounter) <= 0 && !isLoginOK) {
            clearScreen();
            System.out.println("The last login proof failed! Please, try to register a new user account.");
            isUserLogged = false;
        }

        userData = null; // Delete user data table from memory
        Menu.showMainMenu();
    }

}