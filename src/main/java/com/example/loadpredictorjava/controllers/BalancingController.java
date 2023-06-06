package com.example.loadpredictorjava.controllers;

import com.example.loadpredictorjava.MLModels.HoltsMethod;
import com.example.loadpredictorjava.PredictTraffic;
import com.example.loadpredictorjava.service.ForwardingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class BalancingController {

    @GetMapping("/check")
    public String checkHealth(){
        HoltsMethod holtsMethod = new HoltsMethod("data.txt");
        double expectedLoad = holtsMethod.predict(1);
        if(expectedLoad > 50.00){
            return ForwardingService.callApi("8081");
        }
        return ForwardingService.callApi("8080");
    }
}
