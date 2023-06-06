package com.example.loadpredictorjava.Models;

public class Performance {
    private int timestamp;
    private int port;
    private double load;

    public Performance(int timestamp, int port, double load) {
        this.timestamp = timestamp;
        this.port = port;
        this.load = load;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }
}
