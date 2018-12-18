package com.infoshare.academy.jjdzl1gitowcy.file_tools;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class UserFile {

    public static void addFileFromUser(String filepath) {

        File userFile = new java.io.File(filepath);
        String destination = "src/main/resources/user_test_4.csv";
        File fileToSave = new java.io.File(destination);

        try {
            FileUtils.copyFile(userFile, fileToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
