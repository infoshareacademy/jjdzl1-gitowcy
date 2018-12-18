package com.infoshare.academy.jjdzl1gitowcy.quiz;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Quiz {

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

        System.out.println();

        for (String[] row : quiz) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printQuizHeader() {
        System.out.println("--- LET'S START THE QUIZ ---");
        loadQuiz();
    }
}
