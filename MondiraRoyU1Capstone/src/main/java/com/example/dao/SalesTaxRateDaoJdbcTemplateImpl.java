package com.example.dao;

import com.example.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao{
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_SALES_TAX_RATE_SQL =
            "insert into sales_tax_rate (state,rate) values (?, ?)";

    private static final String SELECT_SALES_TAX_RATEBYSTATE_SQL =
            "select * from sales_tax_rate where state = ?";

    private static final String SELECT_ALL_SALES_TAX_RATES_SQL =
            "select * from sales_tax_rate ";

    private static final String UPDATE_SALES_TAX_RATE_SQL =
            "update sales_tax_rate set rate = ? where state = ? ";

    private static final String DELETE_SALES_TAX_RATE =
            "delete from sales_tax_rate where state = ? ";

    @Autowired
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(
                INSERT_SALES_TAX_RATE_SQL,
                salesTaxRate.getRate(),
                salesTaxRate.getState());

        //String state = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        //salesTaxRate.setRate(state);

        return salesTaxRate;
    }

    @Override
    public SalesTaxRate getSalesTaxRateByState(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATEBYSTATE_SQL, this::mapRowToSalesTaxRate, state);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this console id, return null
            return null;
        }
    }

    @Override
    public List<SalesTaxRate> getAllSalesTaxRates() {

        return jdbcTemplate.query(SELECT_ALL_SALES_TAX_RATES_SQL, this::mapRowToSalesTaxRate);
    }

    @Override
    public void updateSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(
                UPDATE_SALES_TAX_RATE_SQL,
                salesTaxRate.getRate(),
                salesTaxRate.getState()
        );

    }

    @Override
    @Transactional
    public void deleteSalesTaxRate(String state) {

        jdbcTemplate.update(DELETE_SALES_TAX_RATE, state);
    }

    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();

        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));

        return salesTaxRate;
    }


}
