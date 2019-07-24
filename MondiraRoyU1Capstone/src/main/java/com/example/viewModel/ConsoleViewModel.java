package com.example.viewModel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {
    private int consoleId;

    @NotEmpty(message = "Please enter the model of the console")
    private String model;

    @NotEmpty(message = "Please enter manufacturer for the console")
    private String manufacturer;

    @NotEmpty(message = "Please enter memory Amount in the console")
    private String memoryAmount;

    @NotEmpty(message = "Please enter processor for the console")
    private String processor;

    @NotNull(message = "Please supply a Console price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal price;

    @NotNull(message = "Please enter console quantity required")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getConsoleId() == that.getConsoleId() &&
                getQuantity() == that.getQuantity() &&
                getModel().equals(that.getModel()) &&
                getManufacturer().equals(that.getManufacturer()) &&
                getMemoryAmount().equals(that.getMemoryAmount()) &&
                getProcessor().equals(that.getProcessor()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoleId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
