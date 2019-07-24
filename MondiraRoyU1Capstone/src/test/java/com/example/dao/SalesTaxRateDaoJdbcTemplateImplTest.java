package com.example.dao;


import com.example.model.SalesTaxRate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoJdbcTemplateImplTest {
    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Before
    public void setUp() throws Exception {
        List<SalesTaxRate> fees = salesTaxRateDao.getAllSalesTaxRates();
        for (SalesTaxRate s : fees) {

            salesTaxRateDao.deleteSalesTaxRate(s.getState());
        }
    }
    @Test
    public void addSalesTaxRate() {
    }

    @Test
    public void getSalesTaxRateByState() {
        SalesTaxRate rate = salesTaxRateDao.getSalesTaxRateByState("");
    }

    @Test
    public void getAllSalesTaxRates() {
        List<SalesTaxRate> taxes = salesTaxRateDao.getAllSalesTaxRates();
    }

    @Test
    public void updateSalesTaxRate() {
    }

    @Test
    public void deleteSalesTaxRate() {
    }

}