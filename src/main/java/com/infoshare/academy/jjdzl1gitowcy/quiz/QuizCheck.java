package com.infoshare.academy.jjdzl1gitowcy.quiz;

public class QuizCheck {

    public static boolean checkUserAnswer(int numberOfAnswer, String[] currentRowToCheck, String correctAnswer) {

        String checkTheAnswer = userAnswerToString(numberOfAnswer, currentRowToCheck);

        if (checkTheAnswer.equals(correctAnswer)) {
            return true;
        } else {
            return false;
        }
    }

    public static String userAnswerToString(int numberOfAnswer, String[] currentRowToCheck) {

        String answerString = "";

        answerString = currentRowToCheck[numberOfAnswer];

        return answerString;
    }
}
