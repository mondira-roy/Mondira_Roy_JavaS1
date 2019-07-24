package com.example.service;

import com.example.dao.*;
import com.example.model.*;
import com.example.viewModel.ConsoleViewModel;
import com.example.viewModel.GameViewModel;
import com.example.viewModel.InvoiceViewModel;
import com.example.viewModel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class InventoryServiceTest {


    ConsoleDao consoleDao;
    InvoiceDao invoiceDao;
    GameDao gameDao;
    TShirtDao tshirtDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;

    InventoryService inventoryService;


    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpInvoiceDaoMock();
        setUpGameDaoMock();
        setUpTShirtDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxRateDaoMock();

        inventoryService = new InventoryService(consoleDao, invoiceDao, gameDao, tshirtDao,
                processingFeeDao, salesTaxRateDao);
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("Wii");
        console.setManufacturer("Sony");
        console.setMemoryAmount("6GB");
        console.setProcessor("Platinum");
        console.setPrice(new BigDecimal("255.00").setScale(2));
        console.setQuantity(2);

        Console console1 = new Console();

        console1.setModel("Wii");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("6GB");
        console1.setProcessor("Platinum");
        console1.setPrice(new BigDecimal("255.00").setScale(2));
        console1.setQuantity(2);

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(cList).when(consoleDao).getAllConsoles();
        doReturn(cList).when(consoleDao).getConsoleByManufacturer("Sony");
    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(2);
        invoice.setName("John");
        invoice.setStreet("Sedgemoor Lane");
        invoice.setCity("Charlotte");
        invoice.setState("NC");
        invoice.setZipcode("28277");
        invoice.setItemType("Game");
        invoice.setItemId(2);
        invoice.setUnitPrice(BigDecimal.valueOf(10.00));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("10.00"));
        invoice.setTax(new BigDecimal("0.5"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("11.99"));

//        invoice.setSubtotal(BigDecimal.valueOf(invoice.getQuantity()).multiply(invoice.getUnitPrice()));
//        invoice.setTax(salesTaxRateDao.getSalesTaxRateByState("NC").getRate());
//        invoice.setProcessingFee(processingFeeDao.getProcessingFeeByProductType("Game").getFee());
//        invoice.setTotal(invoice.getSubtotal().add(invoice.getProcessingFee().add(invoice.getTax())));


        Invoice invoice1 = new Invoice();
        invoice.setName("John");
        invoice.setStreet("Sedgemoor Lane");
        invoice.setCity("Charlotte");
        invoice.setState("NC");
        invoice.setZipcode("28277");
        invoice.setItemType("Game");
        invoice.setItemId(2);
        invoice.setUnitPrice(BigDecimal.valueOf(10.00));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("10.00"));
        invoice.setTax(new BigDecimal("0.5"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("11.99"));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).getInvoice(2);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
        doReturn(invoiceList).when(invoiceDao).getInvoiceByName("John");
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        Game game = new Game();
        game.setGameId(4);
        game.setTitle("Mario");
        game.setEsrb("PG13");
        game.setDescription("Dungeons and Dragons");
        game.setPrice(new BigDecimal("14.55").setScale(2));
        game.setStudio("NYC");
        game.setQuantity(4);

        Game game1 = new Game();
        //game1.setGameId(4);
        game1.setTitle("Mario");
        game1.setEsrb("PG13");
        game1.setDescription("Dungeons and Dragons");
        game1.setPrice(new BigDecimal("14.55").setScale(2));
        game1.setStudio("NYC");
        game1.setQuantity(4);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(4);
        doReturn(gList).when(gameDao).getAllGames();
        doReturn(gList).when(gameDao).getGameByEsrb("PG13");
        doReturn(gList).when(gameDao).getGameByStudio("NYC");
        doReturn(gList).when(gameDao).getGameByTitle("Mario");


    }

    private void setUpTShirtDaoMock() {
        tshirtDao = mock(TShirtDaoJdbcTemplateImpl.class);

        TShirt tShirt = new TShirt();
        tShirt.setTShirtId(2);
        tShirt.setSize("Large");
        tShirt.setColor("Red");
        tShirt.setDescription("Polo");
        tShirt.setPrice(new BigDecimal("10.00").setScale(2));
        tShirt.setQuantity(1);

        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Large");
        tShirt1.setColor("Red");
        tShirt1.setDescription("Polo");
        tShirt1.setPrice(new BigDecimal("10.00").setScale(2));
        tShirt1.setQuantity(1);

        List<TShirt> tList = new ArrayList<>();
        tList.add(tShirt);

        doReturn(tShirt).when(tshirtDao).addTShirt(tShirt1);
        doReturn(tShirt).when(tshirtDao).getTShirt(2);
        doReturn(tList).when(tshirtDao).getAllTShirts();
        doReturn(tList).when(tshirtDao).getTShirtBySize("Large");
        doReturn(tList).when(tshirtDao).getTShirtByColor("Red");
        //doReturn(tShirt).when(tShirtDao).get("Mario");

    }

    private void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFee.setProductType("Game");

        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFee.setProductType("Game");

        List<ProcessingFee> pList = new ArrayList<>();
        pList.add(processingFee);

        doReturn(processingFee).when(processingFeeDao).addProcessingFee(processingFee1);
        doReturn(processingFee).when(processingFeeDao).getProcessingFeeByProductType("Game");
//        doReturn(processingFee).when(processingFeeDao).getAllProcessingFees();
    }

    private void setUpSalesTaxRateDaoMock() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setRate(BigDecimal.valueOf(0.05));
        salesTaxRate.setState("NC");


        SalesTaxRate salesTaxRate1 = new SalesTaxRate();
        salesTaxRate.setRate(BigDecimal.valueOf(0.05));
        salesTaxRate.setState("NC");

        List<SalesTaxRate> taxList = new ArrayList<>();
        taxList.add(salesTaxRate);

        doReturn(salesTaxRate).when(salesTaxRateDao).addSalesTaxRate(salesTaxRate1);
        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRateByState("NC");
//        doReturn(salesTaxRate).when(salesTaxRateDao).getAllSalesTaxRates();

    }

    @Test
    public void findInvoice() {
        InvoiceViewModel invoice = new InvoiceViewModel();
        // Invoice invoice = new Invoice();
        // invoice.setInvoiceId(2);
        invoice.setName("John");
        invoice.setStreet("Sedgemoor Lane");
        invoice.setCity("Charlotte");
        invoice.setState("NC");
        invoice.setZipcode("28277");
        invoice.setItemType("Game");
        invoice.setItemId(2);
//        invoice.setUnitPrice(BigDecimal.valueOf(14.55));
        invoice.setQuantity(4);
//        invoice.setSubtotal(BigDecimal.valueOf(invoice.getQuantity()).multiply(invoice.getUnitPrice()));
//        invoice.setTax(salesTaxRateDao.getSalesTaxRateByState("NC").getRate());
//        invoice.setProcessingFee(processingFeeDao.getProcessingFeeByProductType("Game").getFee());
//        invoice.setTotal(invoice.getSubtotal().add(invoice.getProcessingFee().add(invoice.getTax())));

    }


//    @Test
//    public void updateInvoice() {
//    }
//=========================TSHIRT===============================
    @Test
    public void testSaveFindTShirt() {
        TShirtViewModel tshirtvm = new TShirtViewModel();

        tshirtvm.setSize("Large");
        tshirtvm.setColor("Red");
        tshirtvm.setDescription("Polo");
        tshirtvm.setPrice(new BigDecimal("10.00").setScale(2));
        tshirtvm.setQuantity(1);

        tshirtvm = inventoryService.saveTShirt(tshirtvm);
        TShirtViewModel fromService = inventoryService.findTShirt(tshirtvm.gettShirtId());
        assertEquals(tshirtvm, fromService);
    }



//=====================GAME==================
//
    @Test
    public void testSaveFindGame() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Mario");
        game.setEsrb("PG13");
        game.setDescription("Dungeons and Dragons");
        game.setPrice(new BigDecimal("14.55").setScale(2));
        game.setStudio("NYC");
        game.setQuantity(4);
        game = inventoryService.saveGame(game);
        GameViewModel fromService = inventoryService.findGame(game.getGameId());
        assertEquals(game, fromService);
    }


//=========================CONSOlE==================

    @Test
    public void testSaveFindConsole() {
        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("Wii");
        console.setManufacturer("Sony");
        console.setMemoryAmount("6GB");
        console.setProcessor("Platinum");
        console.setPrice(new BigDecimal("255.00").setScale(2));
        console.setQuantity(2);

        console = inventoryService.saveConsole(console);
        ConsoleViewModel fromService = inventoryService.findConsole(console.getConsoleId());
        assertEquals(console, fromService);
//    }
//
//        @Test
//        public void findConsoleByManufacturer() {
//
//        }
    }
}