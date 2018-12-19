package com.infoshare.academy.jjdzl1gitowcy.file_tools;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.showAddQuizMenu;
import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.showMainMenu;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

public class UserFile {

    public static void addFileFromUser(String filepath) {

        int numberOfFilesInResources = numberOfFilesInDirectory();
        String typeOfQuizLanguage = typeOfQuizLanguage();
        int fileNameNumber = numberOfFilesInResources + 1;

        File userFile = new File(filepath);
        String destination = "src/main/resources/" + typeOfQuizLanguage + "_" + fileNameNumber + ".csv";
        File fileToSave = new File(destination);

        try {
            FileUtils.copyFile(userFile, fileToSave);
            clearScreen();
            System.out.println("Your file was successfully saved!");
            System.out.println();
            showMainMenu();
        } catch (IOException e) {
            clearScreen();
            System.out.println("Something went wrong. Try again...");
            System.out.println();
            showAddQuizMenu();
        }
    }

    public static int numberOfFilesInDirectory() {

        String resourcesPath = "src/main/resources";
        File directory = new File(resourcesPath);

        return directory.list().length;
    }

    public static String typeOfQuizLanguage() {

        System.out.println();
        System.out.println("Choose what type quiz language you want to add");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type: ");
        String typeOfQuizLanguage = scanner.nextLine();

        return typeOfQuizLanguage;
    }
}
