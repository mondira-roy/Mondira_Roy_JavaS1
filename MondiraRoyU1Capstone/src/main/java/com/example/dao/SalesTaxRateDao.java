package com.example.dao;

import com.example.model.SalesTaxRate;

import java.util.List;

public interface SalesTaxRateDao {
    //Dao for SalesTaxRateDao

    SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate);

    List<SalesTaxRate> getAllSalesTaxRates();

    void updateSalesTaxRate(SalesTaxRate salesTaxRate);

    void deleteSalesTaxRate(String state);

    //Defining the additional operations(Get sales Tax Rate by State) to be performed on SalesTaxRate table

    SalesTaxRate getSalesTaxRateByState(String state);

}
