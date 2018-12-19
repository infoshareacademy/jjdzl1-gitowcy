package com.infoshare.academy.jjdzl1gitowcy.menu;

import static com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice.userChoice;

public class Menu {

    //This is var(flag) that tells us which menu the UserChoice.userChoice method was called from
    public static int fromWhatMenu = 0;
    public static String quizName = "";

    public static void showMainMenu() {
        System.out.println("--- CHOOSE WHAT YOU WANT TO DO ---");
        System.out.println("1 - Solve a Quiz");
        System.out.println("2 - Add a Quiz");
        System.out.println("Q - Exit the program");

        //First level of menu
        fromWhatMenu = 1;
        userChoice();
    }

    public static void showQuizMenu() {
        System.out.println("--- CHOOSE QUIZ TO SOLVE ---");
        System.out.println("1 - Java");
        System.out.println("2 - PHP");
        System.out.println("3 - HTML");
        System.out.println("4 - Back to Main Menu");
        System.out.println("Q - Exit the program");

        //Second level of menu
        fromWhatMenu = 2;
        userChoice();
    }

    public static void showQuizStartMenu(String chosenLanguage) {
        if (chosenLanguage.equals("1")) {
            quizName = "Java";
        } else if (chosenLanguage.equals("2")) {
            quizName = "PHP";
        } else if (chosenLanguage.equals("3")) {
            quizName = "HTML";
        } else {
            System.out.println("Hmm, we don't have this choice. Try again...");
        }

        System.out.println("You choose " + quizName + " quiz!");
        System.out.println("Enter your name/nick below to assign your quiz score to it");
        System.out.println("Q - Back to Main Menu");
        fromWhatMenu = 4;
        userChoice();
    }

    public static void showAddQuizMenu() {
        System.out.println("--- ADDING YOUR QUIZ FILE TO PROGRAM ---");
        System.out.println("Your quiz must be saved as a csv file!");

        //Third level of menu
        fromWhatMenu = 3;
        userChoice();
    }
}
