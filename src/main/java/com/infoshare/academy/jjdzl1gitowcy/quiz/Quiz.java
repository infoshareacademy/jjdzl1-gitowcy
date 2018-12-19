package com.infoshare.academy.jjdzl1gitowcy.quiz;

import au.com.bytecode.opencsv.CSVReader;
import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice.userName;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

public class Quiz {

    public static int goodAnswerCounter = 0;
    public static String[] listOfQuizzes;
    public static int numberOfQuizzes = 0;
    public static String quizNameToSolve;
    public static String userResultsToSave;

    public static void loadQuiz() {

        String quizFilePath = "src/main/resources/" + quizNameToSolve;
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
        int sizeOfQuiz = quiz.size();

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
        printUserResult(sizeOfQuiz);
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

    public static void printUserResult(int quizLength) {
        clearScreen();
        System.out.println("Quiz was ended. Here you have your score.");
        userResultsToSave = userName + ": " + goodAnswerCounter + "/" + quizLength;

        System.out.println(userResultsToSave);
        saveUserResultToFile(userResultsToSave);
    }

    public static void searchFileByName() {

        String quizName = Menu.quizName.toLowerCase();
        String directory = "src/main/resources";
        File dir = new File(directory);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(quizName);
            }
        };

        listOfQuizzes = dir.list(filter);
        numberOfQuizzes = listOfQuizzes.length;

        int j = 1;

        if (listOfQuizzes == null) {
            System.out.println("We don't have quiz in this language...");
        } else if (listOfQuizzes.length == 1) {

            quizNameToSolve = listOfQuizzes[0];
            printQuizHeader();
        } else {

            System.out.println("Select the quiz you want to solve:");
            for (int i = 0; i < listOfQuizzes.length; i++) {
                System.out.println(j + ". " + listOfQuizzes[i]);
                j++;
            }
            chooseQuizToSolve(listOfQuizzes);
        }
    }

    public static void chooseQuizToSolve(String[] listOfQuizzes) {

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Your choice (enter the number of file): ");
        int numberFromQuizListToSolve = scanner.nextInt();

        quizNameToSolve = listOfQuizzes[numberFromQuizListToSolve - 1];
        loadQuiz();
    }

    public static void saveUserResultToFile(String userResultsToSave) {

        String destToSave = "src/main/resources/users_results.txt";
        File file = new File(destToSave);
        FileWriter resultToSave = null;

        try {
            resultToSave = new FileWriter(file, true);
            resultToSave.write(userResultsToSave);
            resultToSave.write("\n");
            resultToSave.close();
            System.out.println("Your score was successfully saved");
        } catch (IOException e) {
            System.out.println("Something went wrong. We were unable to save your score...");
            e.printStackTrace();
        }
    }
}
