package com.company.HomePackage;

public class Home {
    private String flooringType;
    private double squareFootage;
    private String typeOfHome;

    public Home(String flooringType, double squareFootage, String typeOfHome) {
        this.flooringType = flooringType;
        this.squareFootage = squareFootage;
        this.typeOfHome = typeOfHome;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public String getTypeOfHome() {
        return typeOfHome;
    }

    public void setTypeOfHome(String typeOfHome) {
        this.typeOfHome = typeOfHome;
    }
}
