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

        int noElements = allLines.get(0).length;

        int noLines = allLines.size();


//        System.out.println( noElements + "   " + noLines);

        for (int j = 1; j < noLines; j++) {
            String[] singleRow = allLines.get(j);

            for (int i = 0; i < noElements - 1; i++) {
                System.out.print(singleRow[i] + " ");
            }
            System.out.println();
        }


    }
}
