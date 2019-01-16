package com.infoshare.academy.jjdzl1gitowcy.user_controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.showLoginMenu;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;
import static com.infoshare.academy.jjdzl1gitowcy.user_controller.InputFile.getUserFromFile;
import static com.infoshare.academy.jjdzl1gitowcy.user_controller.InputFile.numberOfUsers;

public class UserRegistration {

    public static void registration() {

        int userId = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter login: ");
        String login = scanner.next();

        while (!checkIfLoginExist(login)) {
            System.out.println("This login is busy! Try with different login.\n");
            System.out.print("Enter login: ");
            login = scanner.next();
        }

        System.out.print("Enter password: ");
        String password = scanner.next();

        userId = numberOfUsers + 1;
        String accountToAdd = login + "|" + password + "|" + userId;

        if (!accountToAdd.equals("|")) {
            saveAccountToFile(accountToAdd);
        }
    }

    public static void saveAccountToFile(String accountToAdd) {

        String fileDestination = "src/main/resources/users.csv";
        File file = new File(fileDestination);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(accountToAdd);
            fileWriter.write("\n");
            fileWriter.close();
            System.out.println("\nYour account was successfully create.");
            System.out.println("Now you can login to program.");
            TimeUnit.SECONDS.sleep(3);
        } catch (IOException | InterruptedException e) {
            System.out.println("Something went wrong. We were unable to create your account...");
            e.printStackTrace();
        } finally {
            clearScreen();
            showLoginMenu();
        }
    }

    public static boolean checkIfLoginExist(String login) {

        Boolean isLoginExist = false;
        String[] usersData = getUserFromFile(login);

        if (usersData != null) {
            isLoginExist = false;
        } else {
            isLoginExist = true;
        }

        return isLoginExist;
    }
}
