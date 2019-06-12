package com.company;

public class CoffeeMaker {
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;

    public CoffeeMaker(String manufacturerIn,
                       String modelIn, int carafeSizeIn,
                       int cupsLeftIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.carafeSize = carafeSizeIn;
        this.cupsLeft = cupsLeftIn;
        this.powered = poweredIn;
    }

    private boolean powered;

    public String getManufacturer() {

        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getmodel() {
        return model;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public int getCarafeSize() {
        return carafeSize;
    }

    public void setCarafeSize(int carafeSize) {
        this.carafeSize = carafeSize;
    }

    public int getCupsLeft() {
        return cupsLeft;
    }

    public void setCupsLeft(int cupsLeft) {
        this.cupsLeft = cupsLeft;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    public void brew(){
        if (isPowered()) {
            this.cupsLeft = getCarafeSize();
        }
    }
    public void pourCoffee(int numCups){
        if (getCupsLeft() > numCups) {
            this.cupsLeft = getCupsLeft() - numCups;
        } else {
            this.cupsLeft = 0;
        }

    }
}
