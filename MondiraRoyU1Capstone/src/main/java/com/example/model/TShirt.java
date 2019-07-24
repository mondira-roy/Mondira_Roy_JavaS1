package com.example.model;

import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {
    private int tShirtId;
    private String size;
    private String color;
    private String description;
    private int quantity;
    private BigDecimal price;

    public int getTShirtId() {
        return tShirtId;
    }

    public void setTShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt shirt = (TShirt) o;
        return tShirtId == shirt.tShirtId &&
                getQuantity() == shirt.getQuantity() &&
                getSize().equals(shirt.getSize()) &&
                getColor().equals(shirt.getColor()) &&
                getDescription().equals(shirt.getDescription()) &&
                getPrice().equals(shirt.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, getSize(), getColor(), getDescription(), getQuantity(), getPrice());
    }
}
