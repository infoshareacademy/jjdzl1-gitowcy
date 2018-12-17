package com.infoshare.academy.jjdzl1gitowcy.menu;

import javax.jws.soap.SOAPBinding;

public class Menu {

    //This is var(flag) that tells us which menu the UserChoice.userChoice method was called from
    public static int fromWhatMenu = 0;

    public static void showMainMenu() {
        System.out.println("--- CHOOSE WHAT YOU WANT TO DO ---");
        System.out.println("1 - Solve a Quiz");
        System.out.println("2 - Add a Quiz");
        System.out.println("3 - Exit the program");

        //First level of menu
        fromWhatMenu = 1;
        UserChoice.userChoice();
    }

    public static void showQuizMenu() {
        System.out.println("--- CHOOSE QUIZ TO SOLVE ---");
        System.out.println("1 - Java");
        System.out.println("2 - PHP");
        System.out.println("3 - HTML");
        System.out.println("4 - Back to Main Menu");

        //Second level of menu
        fromWhatMenu = 2;
        UserChoice.userChoice();
    }

    public static void showAddQuizMenu() {
        System.out.println("--- ADDING YOUR QUIZ TO PROGRAM ---");
        System.out.println("Your quiz must be saved as a csv file!");
        System.out.println("Q - Back to Main Menu");

        //Third level of menu
        fromWhatMenu = 3;
        UserChoice.userChoice();
    }
}
