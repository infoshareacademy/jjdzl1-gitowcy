package com.infoshare.academy.jjdzl1gitowcy.menu;

import com.infoshare.academy.jjdzl1gitowcy.file_tools.File;

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
                Menu.showMainMenu();
            } else {
                File.addQuizFromUserFile(filepath);
            }

        } else {
            System.out.print("Your choice: ");
            Integer userChoice = scanner.nextInt();
            userMenuChoice(userChoice);
        }
    }

    public static void userMenuChoice(Integer userChoice) {

        switch (userChoice) {
            case 1:
                if (Menu.fromWhatMenu == 1) {
                    Menu.showQuizMenu();
                }
                break;
            case 2:
                if (Menu.fromWhatMenu == 1) {
                    Menu.showAddQuizMenu();
                }
                break;
            case 3:
                if (Menu.fromWhatMenu == 1) {
                    System.out.println("Return to us again!");
                    exit(0);
                }
                break;
            case 4:
                if (Menu.fromWhatMenu == 2) {
                    Menu.showMainMenu();
                }
                break;
            default: {
                System.out.println("Error, choice not found!");
            }
        }
    }
}
