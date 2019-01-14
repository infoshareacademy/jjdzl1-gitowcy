package com.infoshare.academy.jjdzl1gitowcy.quiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnswerOrderGenerator {

    protected static String[] newOrderOfQuestions(String[] rowToRoll) {

        String[] rowToRoll4 = new String[4];
        String[] rolledRow = rowToRoll;
        try {
            for (int i = 1; i < rowToRoll.length - 1; i++) {
                rowToRoll4[i - 1] = rowToRoll[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Size of the array is not correct: " + rowToRoll.length);
        }
        List<String> list = (Arrays.asList(rowToRoll4));
        Collections.shuffle(list);
        String[] rolledRow4 = new String[list.size()];
        list.toArray(rolledRow4);
        try {
            for (int i = 1; i < rowToRoll.length - 1; i++) {
                rolledRow[i] = rolledRow4[i - 1];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Size of the array is not correct: " + rowToRoll.length);
        }
        return rolledRow;
    }
}
