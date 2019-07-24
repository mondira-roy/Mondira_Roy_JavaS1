package com.example.viewModel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirtViewModel {
    private int tShirtId;

    @NotEmpty(message = "Please enter size")
    private String size;

    @NotEmpty(message = "Please enter color")
    private String color;

    @NotEmpty(message = "Please give a description")
    private String description;

    @NotEmpty(message = "Please enter quantity")
    private int quantity;

    @NotEmpty(message = "Please supply the price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirtViewModel that = (TShirtViewModel) o;
        return tShirtId == that.tShirtId &&
                quantity == that.quantity &&
                size.equals(that.size) &&
                color.equals(that.color) &&
                description.equals(that.description) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, quantity, price);
    }

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
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
}
