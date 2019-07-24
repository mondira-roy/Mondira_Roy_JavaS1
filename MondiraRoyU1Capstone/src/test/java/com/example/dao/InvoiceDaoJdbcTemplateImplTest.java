package com.example.dao;

import com.example.model.Console;
import com.example.model.Game;
import com.example.model.Invoice;
import com.example.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {
    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    TShirtDao tShirtDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    SalesTaxRateDao salesTaxRateDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;


    @Before
    public void setUp() throws Exception {
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        for (Invoice it : invoices) {
            invoiceDao.deleteInvoice(it.getInvoiceId());
        }

        List<TShirt> tshirts = tShirtDao.getAllTShirts();
        for (TShirt i : tshirts) {
            tShirtDao.deleteTShirt(i.getTShirtId());
        }

        List<Game> games = gameDao.getAllGames();
        for (Game g : games) {
            gameDao.deleteGame(g.getGameId());
        }

        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console c : consoles) {
            consoleDao.deleteConsole(c.getConsoleId());
        }
    }

    @Test
    public void updateInvoice() {

            Invoice invoice = new Invoice();
            invoice.setName("John");
            invoice.setStreet("Dover lane");
            invoice.setCity("Boston");
            invoice.setState("MA");
            invoice.setZipcode("28277");
        invoice.setItemType("Games");
        invoice.setItemId(3);
        invoice.setUnitPrice(new BigDecimal("10.99").setScale(2));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("21.98").setScale(2));
        invoice.setTax(new BigDecimal("0.07").setScale(2));
        invoice.setProcessingFee(new BigDecimal("1.49").setScale(2));
        invoice.setTotal(new BigDecimal("21.98").setScale(2));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = new Invoice();
        invoice1.setName("John");
        invoice1.setStreet("Dover lane");
        invoice1.setCity("Boston");
        invoice1.setState("MA");
        invoice1.setZipcode("28277");
        invoice1.setItemType("Games");
        invoice1.setItemId(3);
        invoice1.setUnitPrice(new BigDecimal("10.99").setScale(2));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(new BigDecimal("21.98").setScale(2));
        invoice1.setTax(new BigDecimal("0.07").setScale(2));
        invoice1.setProcessingFee(new BigDecimal("1.49").setScale(2));
        invoice1.setTotal(new BigDecimal("21.98").setScale(2));

        invoice = invoiceDao.addInvoice(invoice1);

        invoice.setInvoiceId(invoice.getInvoiceId());

        invoiceDao.updateInvoice(invoice);

        // Invoice invoice = invoiceDao.getInvoice(invoice.getInvoiceId());
            assertEquals(invoice,invoice1);
    }



}