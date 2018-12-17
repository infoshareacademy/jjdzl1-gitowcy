package com.infoshare.academy.jjdzl1gitowcy.file_tools;

import au.com.bytecode.opencsv.CSVReader;
import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;
import com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class File {

    public static void addQuizFromUserFile(List<String[]> stringToSave) {

        int testNumber = 4;
        //TODO FIX PROBLEM WITH CONVERTING
        List<String> list = (List<String>) stringToSave;
        boolean fileSave = false;

        try {
            FileWriter writer = new FileWriter("src/main/resources/user_test_" + testNumber + ".csv");

            String lines = list.stream().collect(Collectors.joining(";"));
            writer.write(lines);
            writer.close();
            fileSave = true;
            System.out.println("Saving your quiz file...");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileSave) {
            ScreenManager.clearScreen();
            System.out.println("Your quiz was saved");
            Menu.showMainMenu();
        } else {
            ScreenManager.clearScreen();
            System.out.println("Error occured. Try again...");
            Menu.showAddQuizMenu();
        }
    }

    public static void readFromCSVFile(String filepath) {

        CSVReader reader = null;
        List<String[]> readedFile = null;

        try {
            reader = new CSVReader(new FileReader(filepath), ';', '"', 0);
            readedFile = reader.readAll();
            addQuizFromUserFile(readedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
