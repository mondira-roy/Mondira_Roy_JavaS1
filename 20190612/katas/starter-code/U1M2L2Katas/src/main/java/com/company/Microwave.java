package com.company;

public class Microwave {
    private String manufacturer;
    private String model;
    private String time;
    private int secondsLeft;
    private boolean running;

    public Microwave(String manufacturerIn, String modelIn,
                     String timeIn, int secondsLeftIn,
                     boolean runningIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.time = timeIn;
        this.secondsLeft = secondsLeftIn;
        this.running = runningIn;
    }




    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public boolean getRunning() {
        return running;
    }

    public void setRunning(boolean running) {

        this.running = running;
    }
    public void start(int secondsLeft){
        this.secondsLeft = secondsLeft;
        this.running = true;
    }
    public void stop(){

    }
    public void clear(){

    }
}

