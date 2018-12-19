package com.infoshare.academy.jjdzl1gitowcy.quiz;

import java.util.Scanner;

public class InputKeys {

    protected static Integer inputNumbers(int min, int max) {
        String input$ = "";
        int notEmptyMarker = -1;
        int correctNumber = -1;
        Boolean isInputNotEmpty = false;
        while (!isInputNotEmpty) {
            boolean isNumber = false;
            correctNumber = -1;
            while (!isNumber) {
                try {
                    Scanner choice = new Scanner(System.in);
                    input$ = choice.nextLine();
                    notEmptyMarker = input$.length();
                    correctNumber = Integer.parseInt(input$);
                } catch (NumberFormatException n) {
                    System.out.println("NIncorrect data! Enter the number again: ");
                }
                if (correctNumber >= min && correctNumber <= max) {
                    isNumber = correctNumber == -1 ? false : true;
                } else {
                    System.out.println("Number out of range (" + min + " - " + max + "). Type number once again");
                }
                if (notEmptyMarker < 1) {
                    System.out.println("Again! The entered number can not be an empty set");
                }
                isInputNotEmpty = notEmptyMarker == 0 ? false : true;
            }
        }
        return correctNumber;
    }


        protected static String inputStrings () {
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
    }
