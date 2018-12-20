package com.infoshare.academy.jjdzl1gitowcy.menu;

import java.util.Scanner;

import static com.infoshare.academy.jjdzl1gitowcy.file_tools.UserFile.addFileFromUser;
import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.*;
import static com.infoshare.academy.jjdzl1gitowcy.quiz.Quiz.printQuizHeader;
import static com.infoshare.academy.jjdzl1gitowcy.quiz.Quiz.searchFileByName;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;
import static java.lang.System.exit;

public class UserChoice {

    public static String userName;

    public static void userChoice() {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        if (fromWhatMenu == 3) {
            System.out.print("Enter path to your quiz file (q - back to main menu): ");
            String filepath = scanner.nextLine();

            if (filepath.equals("q") || filepath.equals("Q")) {
                clearScreen();
                showMainMenu();
            } else {
                addFileFromUser(filepath);
            }

        } else if (fromWhatMenu == 4) {
            System.out.print("Your name/nick: ");
            userName = scanner.next();

            if (userName.equals("q") || userName.equals("Q")) {
                clearScreen();
                showMainMenu();
            } else {
                clearScreen();
                searchFileByName();
            }

        } else {
            System.out.print("Your choice: ");
            String userChoice = scanner.next();
            userMenuChoice(userChoice);
        }
    }

    public static void userMenuChoice(String userChoice) {

        switch (userChoice) {
            case "1":
                if (fromWhatMenu == 1) {
                    clearScreen();
                    showQuizMenu();
                } else if (fromWhatMenu == 2) {
                    clearScreen();
                    showQuizStartMenu(userChoice);
                }
                break;
            case "2":
                if (fromWhatMenu == 1) {
                    clearScreen();
                    showAddQuizMenu();
                } else if (fromWhatMenu == 2) {
                    clearScreen();
                    showQuizStartMenu(userChoice);
                }
                break;
            case "3":
                if (fromWhatMenu == 1) {
                    clearScreen();
                    System.out.println("Hmm, we don't have this choice. Try again...");
                    System.out.println();
                    showMainMenu();
                } else if (fromWhatMenu == 2) {
                    clearScreen();
                    showQuizStartMenu(userChoice);
                }
                break;
            case "4":
                if (fromWhatMenu == 1) {
                    clearScreen();
                    System.out.println("Hmm, we don't have this choice. Try again...");
                    System.out.println();
                    showMainMenu();
                } else if (fromWhatMenu == 2) {
                    clearScreen();
                    showMainMenu();
                }
                break;
            case "Q":
                System.out.println("Return to us again!");
                exit(0);
            case "q":
                System.out.println("Return to us again!");
                exit(0);
            default: {
                clearScreen();
                System.out.println("Hmm, we don't have this choice. Try again...");
                System.out.println();
                if (fromWhatMenu == 1) {
                    showMainMenu();
                } else if (fromWhatMenu == 2) {
                    showQuizMenu();
                }
            }
        }
    }
}
