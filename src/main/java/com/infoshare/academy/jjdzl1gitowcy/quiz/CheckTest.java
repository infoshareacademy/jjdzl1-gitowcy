package com.infoshare.academy.jjdzl1gitowcy.quiz;

import java.util.concurrent.TimeUnit;

import static com.infoshare.academy.jjdzl1gitowcy.quiz.Quiz.goodAnswerCounter;

public class CheckTest {

    public static boolean isCorrectAnswer(int noAnswer, String[] rowAnswer) {

        int noCorrectAnswetColumnInCSV = 6;
        int correctAnswerDescription = 5;
        int correctAnswer = Integer.parseInt(rowAnswer[noCorrectAnswetColumnInCSV]);
        if (noAnswer == correctAnswer) {
            goodAnswerCounter += 1;
            System.out.println("EXCELLENT! Good answer.");
            timeSleep(1);
            Prompter.prompt(goodAnswerCounter, rowAnswer[correctAnswerDescription]);
            return true;
        } else {
            System.out.println("Ops... You're wrong.");
            Prompter.prompt(goodAnswerCounter, rowAnswer[correctAnswerDescription]);
            timeSleep(1);
            return false;
        }
    }

    private static void timeSleep(int seconds) {

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
