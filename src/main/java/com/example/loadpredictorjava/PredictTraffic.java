package com.example.loadpredictorjava;

import com.example.loadpredictorjava.Models.Performance;
import com.example.loadpredictorjava.filehandlers.FileInputOutputHandler;
import com.example.loadpredictorjava.MLModels.HoltsMethod;


/*

Timestamp,Port,CPU Load are the columns in the dataset


* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PredictTraffic {


    public void train(){
        ArrayList<String> rows = FileInputOutputHandler.readFileByNameToStringArray("port_load1.csv");
        HoltsMethod holtsMethod = new HoltsMethod("data.txt");
        ArrayList<Performance> performances = new ArrayList<>();

        //Sort the data in chronological order
        for(String row : rows){
            String[] cols = row.split(",");
            performances.add(new Performance(Integer.parseInt(cols[0]),Integer.parseInt(cols[1]), Double.parseDouble(cols[2])));
        }

        Collections.sort(performances, new Comparator<Performance>() {
            @Override
            public int compare(Performance o1, Performance o2) {
                return o1.getTimestamp() - o2.getTimestamp();
            }
        });

        performances.stream().forEach(a-> holtsMethod.learn(a.getLoad()));
        holtsMethod.saveModel();
        System.out.println("Successfully trained");
    }


}
