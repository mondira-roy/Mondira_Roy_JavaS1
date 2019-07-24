package com.example.viewModel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {
    private int gameId;

    @NotEmpty(message = "Please enter title")
    private String title;

    @NotEmpty(message = "Please enter Esrb Rating")
    private String esrb;

    @NotEmpty(message = "Please give a description")
    private String description;

    @NotEmpty(message = "Please enter studio")
    private String studio;

    @NotEmpty(message = "Please enter quantity")
    private int quantity;

    @NotEmpty(message = "Please supply the price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal price;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb() {
        return esrb;
    }

    public void setEsrb(String esrb) {
        this.esrb = esrb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        GameViewModel that = (GameViewModel) o;
        return gameId == that.gameId &&
                quantity == that.quantity &&
                title.equals(that.title) &&
                esrb.equals(that.esrb) &&
                description.equals(that.description) &&
                studio.equals(that.studio) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, esrb, description, studio, quantity, price);
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        GameViewModel that = (GameViewModel) o;
//        return getGameId() == that.getGameId() &&
//                getQuantity() == that.getQuantity() &&
//                getTitle().equals(that.getTitle()) &&
//                getEsrb().equals(that.getEsrb()) &&
//                getDescription().equals(that.getDescription()) &&
//                getStudio().equals(that.getStudio()) &&
//                getPrice().equals(that.getPrice());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getGameId(), getTitle(), getEsrb(), getDescription(), getStudio(), getQuantity(), getPrice());
//    }
}
