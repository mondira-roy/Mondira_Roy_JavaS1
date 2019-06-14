package com.company;

import com.company.interfaces.Vehicle;

public class Car implements Vehicle {
    private String make;
    private String model;
    private int milesTravelled;

    public Car() {
        //default constructor
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMilesTravelled() {
        return milesTravelled;
    }

    public void setMilesTravelled(int milesTravelled) {
        this.milesTravelled = milesTravelled;
    }
}
