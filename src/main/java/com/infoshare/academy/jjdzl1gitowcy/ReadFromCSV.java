package com.infoshare.academy.jjdzl1gitowcy;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ReadFromCSV {

    public static void readFromFile() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("src/main/resources/QuestionsForQuiz.csv"), ';', '"', 0);

        List<String[]> allLines = reader.readAll();

        for (String[] row : allLines) {
            System.out.println(Arrays.toString(row));
        }
    }
}
