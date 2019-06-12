package com.company;

public class Radio {
        private String manufacturer;
        private String model;
        private String station;

    public Radio(String manufacturerIn,
                 String modelIn, String stationIn, int numspeakersIn,
                 int volumeIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.station = stationIn;
        this.numspeakers = numspeakersIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
    }

    private int numspeakers;
        private int volume;
        private boolean powered;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacture) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getNumSpeakers() {
        return numspeakers;
    }

    public void setNumSpeakers(int numspeakers) {
        this.numspeakers = numspeakers;
    }

    public int getVolume() { return volume;  }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    public void togglePower(){
        this.powered = !powered;
    }
}


