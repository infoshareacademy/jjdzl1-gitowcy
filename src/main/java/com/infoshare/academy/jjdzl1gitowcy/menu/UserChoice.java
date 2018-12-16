package com.infoshare.academy.jjdzl1gitowcy.menu;

import java.util.Scanner;

public class UserChoice {

    public static void userChoice() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("YOUR CHOICE: ");
        Integer userChoice = scanner.nextInt();

        userMenuChoice(userChoice);
    }

    public static void userMenuChoice(Integer userChoice) {

        switch (userChoice) {
            case 1:
                //link to first choice
                break;
            case 2:
                //link to second choice
                break;
            case 3:
                //link to end app
                break;
            default: {
                System.out.println("Error, choice not found!");
            }
        }
    }
}
