package com.company;

import com.sun.xml.internal.ws.api.pipe.Engine;

public class Accord extends Car {
    public Accord() {
        //default constructor
    }
    Accord accord=new Accord();
    Transmission transmission= new Transmission();

    private String year;
   private Engine engine;
   private Transmission transmission;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Engine getEngine() {

        return engine;
    }

    public void setEngine(Engine engine) {
        accord.setEngine(new Engine());
        this.engine = engine;
    }

    public Transmission getTransmission() {
        accord.setTransmission(new Transmission());
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
