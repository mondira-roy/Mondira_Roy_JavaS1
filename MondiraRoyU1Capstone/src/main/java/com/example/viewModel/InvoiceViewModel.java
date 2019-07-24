package com.example.viewModel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class InvoiceViewModel {
    private int invoiceId;

    @NotEmpty(message = "Please enter Name")
    private String name;

    @NotEmpty(message = "Please enter Street")
    private String street;

    @NotEmpty(message = "Please enter City")
    private String city;

    @NotEmpty(message = "Please enter State")
    private String state;

    @NotEmpty(message = "Please enter the zipCode")
    private String zipcode;

    @NotEmpty(message = "Please select Item")
    private String itemType;

    @NotNull(message = "Please enter Item Id")
    private int itemId;
    public int getInvoiceId() {
        return invoiceId;
    }

    @NotNull(message = "Please enter quantity")
    @DecimalMax(value = "quantity", inclusive = true)
    @DecimalMin(value = "0", inclusive = true)
    private int quantity;

    public String getName() {
        return name;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    @NotEmpty(message = "Please supply a unit_price")
//    @DecimalMin(value = "0.0", inclusive = true)
//    @DecimalMax(value = "99999.99", inclusive = true)
//        private BigDecimal unitPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return invoiceId == that.invoiceId &&
                itemId == that.itemId &&
                quantity == that.quantity &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipcode.equals(that.zipcode) &&
                itemType.equals(that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipcode, itemType, itemId, quantity);
    }

//    @NotNull(message = "Please supply a subtotal")
//    @DecimalMax(value = "quantity*unit_price", inclusive = true)
//    @DecimalMin(value = "0.0", inclusive = true)
//    private BigDecimal subtotal;
//
//    @NotNull(message = "Please supply value for tax")
//    //@
//    @DecimalMin(value = "0.0", inclusive = true)
//    @DecimalMax(value = "99999.99", inclusive = true)
//        private BigDecimal tax;
//
//    @NotNull(message = "Please supply processingFee")
//    @DecimalMin(value = "0.0", inclusive = true)
//    @DecimalMax(value = "99999.99", inclusive = true)
//        private BigDecimal processingFee;
//
//    @NotNull(message = "value for total")
//    @DecimalMin(value = "0.0", inclusive = true)
//    @DecimalMax(value = "99999.99", inclusive = true)
//        private BigDecimal total;


}

