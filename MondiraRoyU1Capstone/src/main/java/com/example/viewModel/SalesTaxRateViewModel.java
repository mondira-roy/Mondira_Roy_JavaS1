package com.example.viewModel;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesTaxRateViewModel {
    private String state;

    @NotNull(message = "Please enter Tax Rate")
    private BigDecimal rate;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRateViewModel that = (SalesTaxRateViewModel) o;
        return getState().equals(that.getState()) &&
                getRate().equals(that.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getRate());
    }
}
