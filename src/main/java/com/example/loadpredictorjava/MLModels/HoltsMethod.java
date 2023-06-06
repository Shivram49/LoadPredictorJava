package com.example.loadpredictorjava.MLModels;

import com.example.loadpredictorjava.filehandlers.FileInputOutputHandler;

/*
* Level equation: L_t = α * D_t + (1-α) * (L_(t-1) + T_(t-1))
  Trend equation: T_t = β * (L_t - L_(t-1)) + (1-β) * T_(t-1)
  Forecast equation: F_(t+m) = L_t + m * T_t
* */
public class HoltsMethod {

    private double alpha;
    private double beta;
    private double level;
    private double trend;
    private double forecast;
    private String fileName;
    private double prevLevel;
    private double prevTrend;

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getTrend() {
        return trend;
    }

    public void setTrend(double trend) {
        this.trend = trend;
    }

    public double getForecast() {
        return forecast;
    }

    public void setForecast(double forecast) {
        this.forecast = forecast;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getPrevLevel() {
        return prevLevel;
    }

    public void setPrevLevel(double prevLevel) {
        this.prevLevel = prevLevel;
    }

    public double getPrevTrend() {
        return prevTrend;
    }

    public void setPrevTrend(double prevTrend) {
        this.prevTrend = prevTrend;
    }

    public HoltsMethod(String fileName){
        this.fileName = fileName;
        double[] params = FileInputOutputHandler.readFileByNameToDouble(fileName);
        alpha = params[0];
        beta = params[1];
        level = params[2];
        trend = params[3];
        forecast = params[4];
        prevLevel = 0;
        prevTrend = 0;
    }

    public void saveModel(){
        double[] model = new double[]{alpha,beta,level,trend,prevLevel,prevTrend};
        FileInputOutputHandler.writeFileByName(fileName,model);
    }

    //    Trend equation: T_t = β * (L_t - L_(t-1)) + (1-β) * T_(t-1)

    public void learn(double actualLabel){
        level = alpha * actualLabel + (1 - alpha)*(prevLevel + prevTrend);
        trend = beta * (level - prevLevel) + (1 - beta)*prevTrend;
        prevLevel = level;
        prevTrend = trend;
    }

    public double predict(int daysOffset){
        forecast = level + daysOffset*trend;
        return forecast;
    }

}
