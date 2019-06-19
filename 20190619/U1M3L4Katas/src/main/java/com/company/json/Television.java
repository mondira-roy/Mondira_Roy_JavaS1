package com.company.json;

import com.opencsv.bean.CsvBindByName;

public class Television {
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;

//    public Television(String brand, String model, int price, int screenSize) {
//        this.brand = brand;
//        this.model = model;
//        this.price = price;
//        this.screenSize = screenSize;
//    }

    public Television() {
    }

    @CsvBindByName(column = "Price")
    private int price;
    @CsvBindByName(column = "ScreenSize")
    private int screenSize;
}
