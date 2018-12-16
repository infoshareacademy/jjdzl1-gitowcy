package com.infoshare.academy.jjdzl1gitowcy;

import java.io.IOException;

/**
 * Project GITowcy Group!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException{

        try {
            ReadFromCSV.readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
