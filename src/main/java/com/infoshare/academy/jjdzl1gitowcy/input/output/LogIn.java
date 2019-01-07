package com.infoshare.academy.jjdzl1gitowcy.input.output;

import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;
import com.infoshare.academy.jjdzl1gitowcy.quiz.InputKeys;
//import static com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice.userName;
import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.*;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

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

            System.out.print("\nEnter the user NAME to find: ");
            inpUser = InputKeys.inputStrings();
            System.out.print("Entered: " + inpUser);

            if (InputFile.getFromFile(inpUser) != null) {
                checkUser = true;
                System.out.printf("Welcome %s. User name is correct!", inpUser);

            } else {
                checkUser = false;
                if ((logProof - logCounter) > 1) {
                    System.out.printf("Invalid user name! %n%s %s %s %s %ss!",
                            logProofDesc, logCounter, logProof2, (logProof - logCounter), logProof3);
                } else if ((logProof - logCounter) == 1) {
                    System.out.printf("Invalid user name! %n%s %s %s %s %s!",
                            logProofDesc, logCounter, logProof2, (logProof - logCounter), logProof3);
                }
                logCounter++;
            }

            if (checkUser) {

                userData = InputFile.getFromFile(inpUser);
                System.out.print("\nEnter the user PASSWORD to log in: ");
                String inputPass = InputKeys.inputStrings();

                if (inputPass.equals(userData[1])) {
                    clearScreen();
                    System.out.printf("OK %s. You've logged in successfully! %n\n", inpUser);
                    isLoginOK = true;
                    userLoggedName=userData[0];
                    isUserLogged=true;
                } else {
                    if ((logProof - logCounter) > 1) {
                        System.out.printf("Invalid Password! %n%s %s %s %s %ss!",
                                logProofDesc, logCounter, logProof2, (logProof - logCounter), logProof3);
                    } else if ((logProof - logCounter) == 1) {
                        System.out.printf("Invalid Password! %n%s %s %s %s %s!",
                                logProofDesc, logCounter, logProof2, (logProof - logCounter), logProof3);
                    }
                    logCounter++;
                }
            }
        }
        if ((logProof - logCounter) <= 0 && !isLoginOK) {
            clearScreen();
            System.out.println("The last login proof failed! Please, try to register a new user account.");
            isUserLogged=false;
        }

        userData = null;// Delete user data table from memory
        Menu.showMainMenu();
    }

}