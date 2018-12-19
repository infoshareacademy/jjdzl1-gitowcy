package com.infoshare.academy.jjdzl1gitowcy.menu;

import static com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice.userChoice;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

public class Menu {

    // The path to the CSV file chosen after test type question
    public static String pathToCSV;

    //This is var(flag) that tells us which menu the UserChoice.userChoice method was called from
    public static int fromWhatMenu = 0;

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

    public static void choseLevelMenu() {
        clearScreen();
        System.out.println("--- CHOOSE LEVEL OF THE QUIZ ---");
        System.out.println("1 - easy level");
        System.out.println("2 - difficult level");
        System.out.println("3 - Back to Main Menu");
        System.out.println("Q - Exit the program");

        //Fourth level of menu
        fromWhatMenu = 4;
        userChoice();
    }

    public static void showQuizStartMenu(String chosenLanguage) {
        String quizName = "";

        if (chosenLanguage.equals("1")) {
            quizName = "Java";
            Menu pathToJAVAcsv = new Menu();
            pathToJAVAcsv.pathToCSV = "src/main/resources/java_";
        } else if (chosenLanguage.equals("2")) {
            quizName = "PHP";
            Menu pathToPHPcsv = new Menu();
            pathToPHPcsv.pathToCSV = "src/main/resources/php_";
        } else {
            quizName = "HTML";
            Menu pathToHTMLcsv = new Menu();
            pathToHTMLcsv.pathToCSV = "src/main/resources/html_";
        }

        System.out.println("You choose " + quizName + " quiz!");
        choseLevelMenu();
    }

    public static void getTheTestLevel(String chosenLevel) {
        String levelName = "";
        String levelType = "";
        String firstPartPathCSV = pathToCSV;

        if (firstPartPathCSV.toLowerCase().contains("java")) {
            levelType = ("JAVA");
        } else if (firstPartPathCSV.toLowerCase().contains("php")) {
            levelType = ("PHP");
        } else if (firstPartPathCSV.toLowerCase().contains("html")) {
            levelType = ("HTML");
        }

        if (chosenLevel.equals("1")) {
            levelName = "1";
            Menu pathTolevelCSV = new Menu();
            pathTolevelCSV.pathToCSV = firstPartPathCSV + levelName + ".csv";
        } else {
            levelName = "2";
            Menu pathTolevelCSV = new Menu();
            pathTolevelCSV.pathToCSV = firstPartPathCSV + levelName + ".csv";
        }

        System.out.println("You choose " + levelType + " quiz" + " with level " + chosenLevel + ". GoodLuck!");
        System.out.println("Enter your name/nick below to assign your quiz score to it");
        System.out.println("Q - Back to Main Menu");
        // Direct to the nick type receiver
        fromWhatMenu = 5;
        userChoice();
    }

    public static void showAddQuizMenu() {
        System.out.println("--- ADDING YOUR QUIZ TO PROGRAM ---");
        System.out.println("Your quiz must be saved as a csv file!");

        //Third level of menu
        fromWhatMenu = 3;
        userChoice();
    }
}
