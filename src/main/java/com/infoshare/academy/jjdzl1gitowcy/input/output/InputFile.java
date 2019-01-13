package com.infoshare.academy.jjdzl1gitowcy.input.output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputFile {

    protected static String[] getFromFile(String inputToFind) {

        Boolean isUser = false;
        String csvFile = "src/main/resources/users_passwords.csv";
        String line = null;
        String csvSplitBy = "\\p{Punct}";// Lines splitted by "|" - POSIX character class

        List<String[]> dataList = new ArrayList<>();
        String[] correctFileline = null;
        String[] correctFileline$ = null;

        try (BufferedReader br
                     = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] lineOfFileData = line.split(csvSplitBy);
                dataList.addAll(Collections.singleton(lineOfFileData));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        for (String[] fileLine : dataList) {

            if (Arrays.asList(fileLine).contains(inputToFind)) {
                correctFileline = fileLine;
                isUser = true;
                break;
            }
        }
        return correctFileline;
    }
}
