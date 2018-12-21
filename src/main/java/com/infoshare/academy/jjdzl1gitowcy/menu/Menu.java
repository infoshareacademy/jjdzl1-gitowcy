package com.infoshare.academy.jjdzl1gitowcy.menu;

import com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager;

import static com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice.userChoice;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

public class Menu {

    //The path to the CSV file chosen after test type question
    public static String pathToCSV;

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

    public static void showTestLevelMenu() {
        System.out.println("--- CHOOSE LEVEL OF THE QUIZ ---");
        System.out.println("1 - Easy level");
        System.out.println("2 - Medium level");
        System.out.println("3 - Hard level");
        System.out.println("4 - Back to Main Menu");
        System.out.println("Q - Exit the program");

        //Fourth level of menu
        fromWhatMenu = 4;
        userChoice();
    }

    public static void showQuizStartMenu(String chosenLanguage) {

        if (chosenLanguage.equals("1")) {
            quizName = "Java";
            pathToCSV = "src/main/resources/java/java_";
        } else if (chosenLanguage.equals("2")) {
            quizName = "PHP";
            pathToCSV = "src/main/resources/php/php_";
        } else if (chosenLanguage.equals("3")) {
            quizName = "HTML";
            pathToCSV = "src/main/resources/html/html_";
        } else {
            System.out.println("Hmm, we don't have this choice. Try again...");
        }

        //fromWhatMenu = 5;
        clearScreen();
        showTestLevelMenu();
    }

    public static void getTheTestLevel(String chosenLevel) {
        String levelName = "";
        String levelType = "";

        if (pathToCSV.toLowerCase().contains("java")) {
            levelType = "JAVA";
        } else if (pathToCSV.toLowerCase().contains("php")) {
            levelType = "PHP";
        } else  if (pathToCSV.toLowerCase().contains("html")) {
            levelType = "HTML";
        }

        if (chosenLevel.equals("1")) {
            levelName = "1";
            pathToCSV = pathToCSV + levelName + ".csv";
        } else if (chosenLevel.equals("2")) {
            levelName = "2";
            pathToCSV = pathToCSV + levelName + ".csv";
        } else if (chosenLevel.equals("3")) {
            levelName = "3";
            pathToCSV = pathToCSV + levelName + ".csv";
        }

        System.out.println("You coose " + levelType + " quiz with level " + chosenLevel + ". GoodLuck!");
        System.out.println("Enter your name/nick below to assign your quiz score to it");
        System.out.println("Q - Back to Main Menu");

        //Fifth level of menu
        fromWhatMenu = 5;
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
