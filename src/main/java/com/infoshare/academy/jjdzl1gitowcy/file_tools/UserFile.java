package com.infoshare.academy.jjdzl1gitowcy.file_tools;

import com.infoshare.academy.jjdzl1gitowcy.menu.Menu;
import com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class UserFile {

    public static void addFileFromUser(String filepath) {

        int numberOfFilesInResources = numberOfFilesInDirectory();
        int fileNameNumber = numberOfFilesInResources + 1;
        File userFile = new File(filepath);
        String destination = "src/main/resources/user_test_" + fileNameNumber + ".csv";
        File fileToSave = new File(destination);

        try {
            FileUtils.copyFile(userFile, fileToSave);
            ScreenManager.clearScreen();
            System.out.println("Your file was successfully saved!");
            System.out.println();
            Menu.showMainMenu();
        } catch (IOException e) {
            ScreenManager.clearScreen();
            System.out.println("Something went wrong. Try again...");
            System.out.println();
            Menu.showAddQuizMenu();
        }
    }

    public static int numberOfFilesInDirectory() {

        String resourcesPath = "src/main/resources";
        File directory = new File(resourcesPath);

        return directory.list().length;
    }
}
