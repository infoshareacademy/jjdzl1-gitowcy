package com.infoshare.academy.jjdzl1gitowcy.quiz;

import au.com.bytecode.opencsv.CSVReader;
import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.*;
import static com.infoshare.academy.jjdzl1gitowcy.menu.UserChoice.userName;
import static com.infoshare.academy.jjdzl1gitowcy.quiz.InputKeys.inputNumbers;
import static com.infoshare.academy.jjdzl1gitowcy.quiz.QuizCheck.checkUserAnswer;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;
import static com.infoshare.academy.jjdzl1gitowcy.user_controller.LogIn.userLoggedId;
import static com.infoshare.academy.jjdzl1gitowcy.user_controller.LogIn.userLoggedName;

public class Quiz {

    public static int goodAnswerCounter = 0;
    public static String[] listOfQuizzes;
    public static int numberOfQuizzes = 0;
    public static String quizNameToSolve;
    public static String userResultsToSave;
    public static String correctAnswer;
    public static List<String[]> quizLines = null;
    public static String[] currentRowToCheck;
    public static String quizFilePath;


    public static void loadFileQuiz(File quizFile) {

        CSVReader readQuiz = null;

        try {
            readQuiz = new CSVReader(new FileReader(quizFile), ';', '"', 1);
            quizLines = readQuiz.readAll();
            printQuiz(quizLines);
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong. We don't have this quiz file now...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong. We can't load quiz file now...");
            e.printStackTrace();
        }
    }

    public static void loadQuiz() {

        quizFilePath = pathToCSV;
        File quizFile = new File(quizFilePath);

        loadFileQuiz(quizFile);
    }

    public static void loadUsersQuiz(String quizNameFile) {

        quizFilePath = "src/main/resources/users_quiz/" + quizNameFile;
        File quizFile = new File(quizFilePath);

        loadFileQuiz(quizFile);
    }

    public static void printQuiz(List<String[]> quiz) {

        boolean printQuestion;
        int sizeOfQuiz = quiz.size();

        for (String[] row : quiz) {

            printQuestion = false;
            clearScreen();

            currentRowToCheck = AnswerOrderGenerator.newOrderOfQuestions(row);

            for (int i = 0; i < row.length - 1; i++) {

                if (printQuestion == false) {
                    System.out.println(row[0]);
                    printQuestion = true;
                    i++;
                }

                System.out.println(i + ". " + row[i]);
                correctAnswer = row[5];
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

        System.out.println();
        System.out.print("Enter the number of answer: ");


        int userAnswer = inputNumbers(1, 4);

        switch (userAnswer) {
            case 1:
                if (checkUserAnswer(1, currentRowToCheck, correctAnswer))
                    goodAnswerCounter++;
                break;
            case 2:
                if (checkUserAnswer(2, currentRowToCheck, correctAnswer))
                    goodAnswerCounter++;
                break;
            case 3:
                if (checkUserAnswer(3, currentRowToCheck, correctAnswer))
                    goodAnswerCounter++;
                break;
            case 4:
                if (checkUserAnswer(4, currentRowToCheck, correctAnswer))
                    goodAnswerCounter++;
                break;
            default:
                System.out.println("Enter the number of correct answer!");
                break;
        }

    }

    public static void printUserResult(int quizLength) {
        clearScreen();
        System.out.println("Quiz was ended. Here you have your score.");

        if (isUserLogged) {
//            Date dNow = new Date();
//            SimpleDateFormat ft = new SimpleDateFormat("dd_MM_yyyy");
//            String todayDate = ft.format(dNow);
//            String resultDataToSave = String.format("%s, %s, %s, %s, %s, %s", userLoggedName, goodAnswerCounter, quizLength, quizName, levelName, todayDate);
//
//            userResultsToSave = resultDataToSave; //useName + ": " + goodAnswerCounter + "/" + quizLength + ", " + quizName;

            userResultsToSave = userLoggedName + "|" + goodAnswerCounter + "/" + quizLength + "|" + quizName + "|" + userLoggedId;

        } else {
            userResultsToSave = userName + ": " + goodAnswerCounter + "/" + quizLength + ", " + quizName;
        }
        System.out.println(userResultsToSave);

        saveUserResultToFile(userResultsToSave);
    }

    public static void searchFileByName() {

        String quizName = Menu.quizName.toLowerCase();
        String directory = "src/main/resources/users_quiz";
        File dir = new File(directory);
        FilenameFilter filter = (dir1, name) -> name.startsWith(quizName);

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

        loadUsersQuiz(quizNameToSolve);
    }

    public static void saveUserResultToFile(String userResultsToSave) {

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd_MM_yyyy");
        String todayDate = ft.format(dNow);
        //String resultDataToSave = String.format("%s_%s_%s_%s", userName, quizName, levelName, todayDate);
        String destToSave = "src/main/resources/users_results.txt";
        File file = new File(destToSave);
        FileWriter resultToSave = null;

        try {
            resultToSave = new FileWriter(file, true);
            resultToSave.write(userResultsToSave);
            resultToSave.write("\n");
            resultToSave.close();
            System.out.println("Your score was successfully saved.");
            System.out.println();
            TimeUnit.SECONDS.sleep(3);
        } catch (IOException e) {
            System.out.println("Something went wrong. We were unable to save your score...");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            clearScreen();
            showMainMenu();
        }
    }
}
