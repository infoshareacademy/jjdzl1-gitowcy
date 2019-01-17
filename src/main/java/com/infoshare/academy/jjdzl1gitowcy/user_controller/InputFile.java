package com.infoshare.academy.jjdzl1gitowcy.user_controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.infoshare.academy.jjdzl1gitowcy.user_controller.LogIn.userLoggedId;

public class InputFile {

    public static Integer numberOfUsers;

    public static String[] getUserFromFile(String inputToFind) {

        Boolean isUser = false;
        String csvFile = "src/main/resources/users.csv";
        String line = null;
        String csvSplitBy = "\\p{Punct}"; // Lines splitted by "|" - POSIX character class

        List<String[]> dataList = new ArrayList<>();
        String[] correctFileLine = null;
        String[] correctFileline$ = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] lineOfFileData = line.split(csvSplitBy);
                dataList.addAll(Collections.singleton(lineOfFileData));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        numberOfUsers = dataList.size();

        for (String[] fileLine : dataList) {

            if (Arrays.asList(fileLine).contains(inputToFind)) {
                correctFileLine = fileLine;
                isUser = true;
                break;
            }
        }

        return correctFileLine;
    }

    public static List<String[]> getUserDataFromFile() {

        Boolean isData = false;
        String line = null;
        String splitChar = "\\p{Punct}"; // Lines splitted by "|" - POSIX character class
        String fileDataPath = "src/main/resources/users_results.txt";
        List<String[]> userResultData = new ArrayList<>();
        String[] noData = {"You don't have any score yet"};

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileDataPath))){
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineFromFile = line.split(splitChar);

                if (lineFromFile.length != 5) {
                    break;
                } else {
                    if (lineFromFile[4].equals(userLoggedId)) {
                        userResultData.add(lineFromFile);
                        isData = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!isData) {
            userResultData.add(noData);
        }

        return userResultData;
    }
}
