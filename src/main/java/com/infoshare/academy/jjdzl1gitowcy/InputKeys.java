package com.infoshare.academy.jjdzl1gitowcy;

import java.util.Scanner;

public class InputKeys {

    protected static Integer inputNumbers() {
        String input$ = "";
        int notEmptyMarker = -1;
        int correctNumber = -1;
        Boolean isInputNotEmpty = false;
        // Pętla powtarzjąca odczytywanie klawiatury, gdy otrzyma pusty zbiór znaków
        // tzn. gdy zmienna kontrolna przyjmie wartość true
        while (!isInputNotEmpty) {
            boolean isNumber = false;
            correctNumber = -1;
            // Pętla powtarzjąca odczytywanie klawiatury, gdy nie otrzyma liczby
            // zawiera warunek sprawdzający czy podano liczbę, a nie litery
            while (!isNumber) {
                try {
                    Scanner choice = new Scanner(System.in);
                    input$ = choice.nextLine();
                    notEmptyMarker = input$.length();
                    // Przekształcenie podanych znaków na liczbę
                    correctNumber = Integer.parseInt(input$);
                } catch (NumberFormatException n) {
                    System.out.println("Niepoprawne dane! Podaj jeszcze raz liczbę: ");
                }
                // Zmienna kontrolna otrzymuje wartość true,
                // gdy podany ciąg znaków uda się zamienić w liczbę
                isNumber = correctNumber == -1 ? false : true;
            }
            // Warunek sprawdzający czy podano jakikolwiek znak, a nie wciśnięto tylko enter
            if (notEmptyMarker < 1) {
                System.out.println("Jeszcze raz! Podany ciąg znaków nie może być zbiorem pustym");
            }
            // Zmienna kontrolna otrzymuje wartość true, gdy długość podanego ciągu znaków różni się od zero
            isInputNotEmpty = notEmptyMarker == 0 ? false : true;
        }
        // zwraca podaną i zweryfikowaną liczbę po zakończeniu pętli przyjmująco-sprawdzających
        return correctNumber;
    }

    protected static String inputStrings() {
        String input$ = "";
        int notEmptyMarker = -1;
        Boolean isInputNotEmpty = false;
        // Pętla powtarzjąca odczytywanie gdy otrzyma pusty zbiór znaków
        // tzn. gdy zmienna kontrolna przyjmie wartość true
        while (!isInputNotEmpty) {
            {
                Scanner choice = new Scanner(System.in);
                input$ = choice.nextLine();
                notEmptyMarker = input$.length();
            }
            // Warunek sprawdzający czy podano jakikolwiek znak
            if (notEmptyMarker < 1) {
                System.out.println("Jeszcze raz! Podany ciąg znaków nie może być zbiorem pustym");
            }
            // Zmienna kontrolna otrzymuje wartość true, gdy długość podanego cięgu znaków różni się od zero
            isInputNotEmpty = notEmptyMarker == 0 ? false : true;
        }
        // zwraca podany ciąg znaków po zakończeniu pętli
        return input$;
    }

}
