package com.infoshare.academy.jjdzl1gitowcy.user_controller;

import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;
import com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.isUserLogged;
import static com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice.userMenuChoice;
import static com.infoshare.academy.jjdzl1gitowcy.quiz.InputKeys.inputStrings;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;
import static com.infoshare.academy.jjdzl1gitowcy.user_controller.InputFile.getUserDataFromFile;
import static com.infoshare.academy.jjdzl1gitowcy.user_controller.InputFile.getUserFromFile;

public class LogIn {

public static String userLoggedName;
public static String userLoggedId;

    public static void logIn() {

        boolean isLoginOK = false;
        String inpUser = null;
        int logCounter = 1;
        int logProof = 3;
        boolean checkUser = false;
        String[] userData = null;
        String logProofDesc = "Login proof No.";
        String logProof2 = "failed. Left only";
        String logProof3 = "attempt";

        while (!isLoginOK && logCounter <= logProof) {

            System.out.print("\nEnter login: ");
            inpUser = inputStrings();

            if (getUserFromFile(inpUser) != null) {
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

                userData = getUserFromFile(inpUser);
                System.out.print("Enter password: ");
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
                    userLoggedName = inpUser;
                    userLoggedId = userData[2];
                    isUserLogged = true;
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

    public static void userProfile() {

        List<String[]> userDataProfile = getUserDataFromFile();
        String splitChar = "\\p{Punct}";
        Scanner scanner = new Scanner(System.in);

        for (String[] row : userDataProfile) {
            if (row.length < 4) {
                String line = Arrays.toString(row);
                System.out.println(line);
            } else {
                String[] line = Arrays.toString(row).split(splitChar);
                System.out.println("Score: " + line[2].trim() + "/" + line[3].trim() + ", Test: " + line[4].trim());
            }
        }

        System.out.print("\nYour choice: ");
        String choice = scanner.next();
        System.out.println();
        userMenuChoice(choice);
    }
}