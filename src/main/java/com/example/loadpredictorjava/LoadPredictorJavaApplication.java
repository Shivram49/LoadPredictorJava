package com.example.loadpredictorjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoadPredictorJavaApplication {

    public static void main(String[] args) {
        PredictTraffic predictTraffic = new PredictTraffic();
        predictTraffic.train();
        SpringApplication.run(LoadPredictorJavaApplication.class, args);
    }

}
