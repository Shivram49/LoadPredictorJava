package com.example.loadpredictorjava.filehandlers;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileInputOutputHandler {

    public static double[] readFileByNameToDouble(String inputFileName){
        String fileName =  "src/main/resources/" + inputFileName;
        String output = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output = line;
            }
        } catch (IOException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }


        return Arrays.stream(output.split(","))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }


    public static ArrayList<String> readFileByNameToStringArray(String inputFileName){
        String fileName =  "src/main/resources/" + inputFileName;
        ArrayList<String> dataset = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataset.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
        return  dataset;
    }

    public static void writeFileByName(String inputFileName,double[] dataArray){
        String fileName = "src/main/resources/" + inputFileName;
        String data = "";

        for(int i = 0;i < dataArray.length;i++){
            data += String.valueOf(dataArray[i]) + ",";
        }
        data = data.substring(0,data.length() - 1);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
            System.out.println("Data stored successfully.");
        } catch (IOException e) {
            System.err.println("Error storing data: " + e.getMessage());
        }
    }
}
