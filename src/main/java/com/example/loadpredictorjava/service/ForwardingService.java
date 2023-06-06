package com.example.loadpredictorjava.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ForwardingService {

    public static String callApi(String port) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:"+ port + "/check";  // Replace with the actual API URL

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            return responseBody;
        } else {
            System.err.println("API call failed with status code: " + response.getStatusCode());
            return String.valueOf(response.getStatusCode());
        }
    }
}
