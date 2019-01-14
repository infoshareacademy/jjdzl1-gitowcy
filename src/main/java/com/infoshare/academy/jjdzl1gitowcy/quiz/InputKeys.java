package com.infoshare.academy.jjdzl1gitowcy.quiz;

import java.util.Scanner;

import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

public class InputKeys {

    public static Integer inputNumbers(int min, int max) {
        String input$ = "";
        int notEmptyMarker = -1;
        int correctNumber = -1;
        Boolean isInputNotEmpty = false;
        while (!isInputNotEmpty) {
            boolean isNumber = false;
            correctNumber = Integer.MIN_VALUE;
            while (!isNumber) {
                try {
                    Scanner choice = new Scanner(System.in);
                    input$ = choice.nextLine();
                    notEmptyMarker = input$.length();
                    correctNumber = Integer.parseInt(input$);
                } catch (NumberFormatException n) {
                    System.out.println("Incorrect data dane! Input the number once again: ");
                }
                isNumber = correctNumber == Integer.MIN_VALUE ? false : true;
            }
            if (notEmptyMarker < 1) {
                System.out.println("The entered number can not be an empty set! ");
            }
            if (correctNumber < min || correctNumber > max) {
                System.out.printf("Please, enter the Integer from %s to %s %n",min,max);
            } else {
                isInputNotEmpty = notEmptyMarker == 0 ? false : true;
            }
        }
        return correctNumber;
    }

    public static String inputStrings() {
        String input$ = "";
        int notEmptyMarker = -1;
        Boolean isInputNotEmpty = false;

        while (!isInputNotEmpty) {
            {
                Scanner choice = new Scanner(System.in);
                input$ = choice.nextLine();
                notEmptyMarker = input$.length();
            }
            if (notEmptyMarker < 1) {
                System.out.println("Again! The entered string can not be an empty set");
            }
            isInputNotEmpty = notEmptyMarker == 0 ? false : true;
        }
        return input$;
    }

    public static void pressAnyKeyToContinue()
    {
        clearScreen();
        System.out.println("Press Enter key to continue...");

        try {
            System.in.read();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}