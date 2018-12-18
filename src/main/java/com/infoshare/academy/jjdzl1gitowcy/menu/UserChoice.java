package com.infoshare.academy.jjdzl1gitowcy.menu;

import com.infoshare.academy.jjdzl1gitowcy.file_tools.UserFile;
import com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager;

import java.util.Scanner;

import static java.lang.System.exit;

public class UserChoice {

    public static void userChoice() {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        if (Menu.fromWhatMenu == 3) {
            System.out.print("Enter path to your quiz file (q - back to main menu): ");
            String filepath = scanner.nextLine();

            if (filepath.equals("q") || filepath.equals("Q")) {
                ScreenManager.clearScreen();
                Menu.showMainMenu();
            } else {
                UserFile.addFileFromUser(filepath);
            }

        } else if (Menu.fromWhatMenu == 4) {
            System.out.print("Your name/nick: ");
            String userName = scanner.next();

            if (userName.equals("q") || userName.equals("Q")) {
                ScreenManager.clearScreen();
                Menu.showMainMenu();
            } else {
                //Method to enter into quiz with your name
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
                if (Menu.fromWhatMenu == 1) {
                    ScreenManager.clearScreen();
                    Menu.showQuizMenu();
                } else if (Menu.fromWhatMenu == 2) {
                    ScreenManager.clearScreen();
                    Menu.showQuizStartMenu(userChoice);
                }
                break;
            case "2":
                if (Menu.fromWhatMenu == 1) {
                    ScreenManager.clearScreen();
                    Menu.showAddQuizMenu();
                } else if (Menu.fromWhatMenu == 2) {
                    ScreenManager.clearScreen();
                    Menu.showQuizStartMenu(userChoice);
                }
                break;
            case "3":
                if (Menu.fromWhatMenu == 1) {
                    ScreenManager.clearScreen();
                    System.out.println("Hmm, we don't have this choice. Try again...");
                    System.out.println();
                    Menu.showMainMenu();
                } else if (Menu.fromWhatMenu == 2) {
                    ScreenManager.clearScreen();
                    Menu.showQuizStartMenu(userChoice);
                }
                break;
            case "4":
                if (Menu.fromWhatMenu == 1) {
                    ScreenManager.clearScreen();
                    System.out.println("Hmm, we don't have this choice. Try again...");
                    System.out.println();
                    Menu.showMainMenu();
                } else if (Menu.fromWhatMenu == 2) {
                    ScreenManager.clearScreen();
                    Menu.showMainMenu();
                }
                break;
            case "Q":
                System.out.println("Return to us again!");
                exit(0);
            case "q":
                System.out.println("Return to us again!");
                exit(0);
            default: {
                ScreenManager.clearScreen();
                System.out.println("Hmm, we don't have this choice. Try again...");
                System.out.println();
                if (Menu.fromWhatMenu == 1) {
                    Menu.showMainMenu();
                } else if (Menu.fromWhatMenu == 2) {
                    Menu.showQuizMenu();
                }
            }
        }
    }
}
