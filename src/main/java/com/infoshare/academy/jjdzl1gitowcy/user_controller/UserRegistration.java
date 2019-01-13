package com.infoshare.academy.jjdzl1gitowcy.user_controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.infoshare.academy.jjdzl1gitowcy.menu.Menu.showLoginMenu;
import static com.infoshare.academy.jjdzl1gitowcy.screen_tools.ScreenManager.clearScreen;

public class UserRegistration {

    public static void registration() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter login: ");
        String login = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        String accountToAdd = login + "|" + password;

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
            System.out.println("Your account was successfully create.");
            System.out.println("Now you can login to program");
            TimeUnit.SECONDS.sleep(3);
        } catch (IOException | InterruptedException e) {
            System.out.println("Something went wrong. We were unable to create your account...");
            e.printStackTrace();
        } finally {
            clearScreen();
            showLoginMenu();
        }
    }
}
