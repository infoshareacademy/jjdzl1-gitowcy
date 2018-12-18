package com.infoshare.academy.jjdzl1gitowcy.quiz;

import au.com.bytecode.opencsv.CSVReader;
import com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

public class Quiz {

    public static int goodAnswerCounter = 0;

    public static void loadQuiz() {

        String quizFilePath = "src/main/resources/test_quiz.csv";
        File quizFile = new File(quizFilePath);
        CSVReader readQuiz = null;

        try {
            readQuiz = new CSVReader(new FileReader(quizFile), ';', '"', 1);
            List<String[]> quizLines = readQuiz.readAll();
            printQuiz(quizLines);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printQuiz(List<String[]> quiz) {

        boolean printQuestion;

        for (String[] row : quiz) {

            printQuestion = false;
            clearScreen();

            for (int i = 0; i < row.length - 1; i++) {

                if (printQuestion == false) {
                    System.out.println(row[0]);
                    printQuestion = true;
                    i++;
                }

                System.out.println(i + ". " + row[i]);
            }
            getAnswerFromUser();
        }

        clearScreen();
        System.out.println("Quiz was ended. Here you have your score.");
        System.out.println(UserChoice.userName + ": " + goodAnswerCounter + "/" + quiz.size());
    }

    public static void printQuizHeader() {
        System.out.println("--- LET'S START THE QUIZ ---");
        loadQuiz();
    }

    public static void getAnswerFromUser() {

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the number of answer: ");
        int userAnswer = scanner.nextInt();

        switch (userAnswer) {
            case 1:
                break;
            case 2:
                goodAnswerCounter++;
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }
}
