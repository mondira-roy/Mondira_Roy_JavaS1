package com.example.service;

import com.example.Exception.NotFoundException;
import com.example.dao.*;
import com.example.model.Console;
import com.example.model.Game;
import com.example.model.Invoice;
import com.example.model.TShirt;
import com.example.viewModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryService {
    ConsoleDao consoleDao;
    InvoiceDao invoiceDao;
    GameDao gameDao;
    TShirtDao tShirtDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;

    @Autowired
    public InventoryService(ConsoleDao consoleDao, InvoiceDao invoiceDao, GameDao gameDao,
                            TShirtDao tShirtDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao) {
        this.consoleDao = consoleDao;
        this.invoiceDao = invoiceDao;
        this.gameDao = gameDao;
        this.tShirtDao = tShirtDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
    }

    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {

        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());

        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());

        BigDecimal unitprice = new BigDecimal("0.00");
        int quantity;
        int quantityAtHand;
        if (invoice.getItemType().equals("Consoles")) {
            Console console = consoleDao.getConsole(invoice.getItemId());
            unitprice = console.getPrice();

            //DB quantity value
            quantityAtHand = console.getQuantity();

            // User input quantity value
            quantity = invoiceViewModel.getQuantity();

            //Updating the console table with deprecated quantity
            console.setQuantity(quantityAtHand - quantity);
        } else if (invoice.getItemType().equals("Games")) {
            Game game = gameDao.getGame(invoice.getItemId());

            unitprice = game.getPrice();
            //DB quantity value
            quantityAtHand = game.getQuantity();

            // User input quantity value
            quantity = invoiceViewModel.getQuantity();

            //Updating the game table with deprecated quantity
            game.setQuantity(quantityAtHand - quantity);

        } else if (invoice.getItemType().equals("T-Shirts")) {
            TShirt tShirt = tShirtDao.getTShirt(invoice.getItemId());

            unitprice = tShirt.getPrice();
            //DB quantity value
            quantityAtHand = tShirt.getQuantity();

            // User input quantity value
            quantity = invoiceViewModel.getQuantity();

            //Updating the TShirt table with deprecated quantity
            tShirt.setQuantity(quantityAtHand - quantity);

        } else {
            throw new NotFoundException("Requested Item not found");
        }

        invoice.setUnitPrice(unitprice);
        invoice.setQuantity(quantity);

        invoice.setSubtotal(unitprice
                .multiply(BigDecimal.valueOf(quantity)));

        BigDecimal taxRate;
        taxRate = salesTaxRateDao.getSalesTaxRateByState(invoice.getState()).getRate();

        BigDecimal processingfee;
        processingfee = processingFeeDao.getProcessingFeeByProductType(invoice.getItemType()).getFee();


        invoice.setTax(taxRate.multiply(invoice.getSubtotal()));
        invoice.setProcessingFee(processingfee);
        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()));
        invoice = invoiceDao.addInvoice(invoice);

        invoiceViewModel.setInvoiceId(invoice.getItemId());

        return invoiceViewModel;
    }

    public InvoiceViewModel findInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);
        if (invoice == null)
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }


    public void removeInvoice(int id) {
        invoiceDao.deleteInvoice(id);
    }

    public void updateInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceViewModel.getInvoiceId());
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());

        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());

//calculting the subTotal and Total based on the quantity and unit_price.
        // adding the taxes and processing fees.

        BigDecimal unitprice = new BigDecimal("0.00");
        int quantity = 0 ;
        int quantityAtHand;

        if (invoice.getItemType().equals("console")) {
            Console console = consoleDao.getConsole(invoice.getItemId());

            unitprice = console.getPrice();
            //DB quantity value
            quantityAtHand = console.getQuantity();

            // User input quantity value
            quantity = invoiceViewModel.getQuantity();

            //Updating the console table with deprecated quantity
            console.setQuantity(quantityAtHand - quantity);

        } else if (invoice.getItemType().equals("game")) {
            Game game = gameDao.getGame(invoice.getItemId());

            unitprice = game.getPrice();
            //DB quantity value
            quantityAtHand = game.getQuantity();

            // User input quantity value
            quantity = invoiceViewModel.getQuantity();
            //Updating the console table with deprecated quantity
            game.setQuantity(quantityAtHand - quantity);

        } else if (invoice.getItemType().equals("tshirt")) {
            TShirt tShirt = tShirtDao.getTShirt(invoice.getItemId());

            unitprice = tShirt.getPrice();
            //DB quantity value
            quantityAtHand = tShirt.getQuantity();

            // User input quantity value
            quantity = invoiceViewModel.getQuantity();
            //Updating the console table with deprecated quantity
            tShirt.setQuantity(quantityAtHand - quantity);

        } else {
//            throw new NotFoundException("not found");
        }

        invoice.setUnitPrice(unitprice);
        invoice.setQuantity(quantity);

        invoice.setSubtotal(unitprice
                .multiply(BigDecimal.valueOf(quantity)));

        BigDecimal taxRate;
        taxRate = salesTaxRateDao.getSalesTaxRateByState(invoice.getState()).getRate();

        BigDecimal processingfee;
        processingfee = processingFeeDao.getProcessingFeeByProductType(invoice.getItemType()).getFee();


        invoice.setTax(taxRate.multiply(invoice.getSubtotal()));
        invoice.setProcessingFee(processingfee);
        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()));

        invoiceDao.updateInvoice(invoice);


    }

    //=========================sales taxes==================
    public SalesTaxRateViewModel getSalesTaxRateByState(SalesTaxRateViewModel state) {
        return null;
    }

    //=======================TShirt==============
    public TShirtViewModel saveTShirt(TShirtViewModel tvm) {
        TShirt tShirt = new TShirt();
//        tShirt.setTShirtId(tvm.gettShirtId());
        tShirt.setSize(tvm.getSize());
        tShirt.setColor(tvm.getColor());
        tShirt.setDescription(tvm.getDescription());
        tShirt.setPrice(tvm.getPrice());
        tShirt.setQuantity(tvm.getQuantity());
        tShirt = tShirtDao.addTShirt(tShirt);

        tvm.settShirtId(tShirt.getTShirtId());
        return tvm;
    }

    public TShirtViewModel findTShirt(int tShirtId) {

        TShirt tShirt = tShirtDao.getTShirt(tShirtId);
        if (tShirt == null)
            return null;
        else
            return buildTShirtViewModel(tShirt);
    }


    public void updateTShirt(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.setTShirtId(tShirtViewModel.gettShirtId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirtDao.updateTShirt(tShirt);
    }

    public void removeTShirt(int tShirtId, TShirtDao tShirtDao) {

        tShirtDao.deleteTShirt(tShirtId);
    }

    // =====================GAME===============
    public GameViewModel saveGame(GameViewModel gvm) {

        Game game = new Game();
//        game.setGameId(gvm.getGameId());
        game.setTitle(gvm.getTitle());
        game.setEsrb(gvm.getEsrb());
        game.setDescription(gvm.getDescription());
        game.setPrice(gvm.getPrice());
        game.setStudio(gvm.getStudio());
        game.setQuantity(gvm.getQuantity());
        game = gameDao.addGame(game);
        gvm.setGameId(game.getGameId());
//        Game game1 = new Game();
//        game.setGameId(gvm.getGameId());
//        game.setTitle(gvm.getTitle());
//        game.setEsrb(gvm.getEsrb());
//        game.setDescription(gvm.getDescription());
//        game.setPrice(gvm.getPrice());
//        game.setStudio(gvm.getStudio());
//        game.setQuantity(gvm.getQuantity());
        return gvm;
    }

    public GameViewModel findGame(int gameId) {
        Game game = gameDao.getGame(gameId);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public void removeGame(int gameId) {

        gameDao.deleteGame(gameId);
    }

    public void updateGame(GameViewModel gameviewModel) {
        Game game = new Game();
        game.setGameId(gameviewModel.getGameId());
        game.setTitle(gameviewModel.getTitle());
        game.setEsrb(gameviewModel.getEsrb());
        game.setDescription(gameviewModel.getDescription());
        game.setPrice(gameviewModel.getPrice());
        game.setStudio(gameviewModel.getStudio());
        game.setQuantity(gameviewModel.getQuantity());

        gameDao.updateGame(game);
    }

    //===============console==============
    public void updateConsole(ConsoleViewModel consoleviewModel) {
        Console console = new Console();
        console.setConsoleId(consoleviewModel.getConsoleId());
        console.setModel(consoleviewModel.getModel());
        console.setManufacturer(consoleviewModel.getManufacturer());
        console.setMemoryAmount(consoleviewModel.getMemoryAmount());
        console.setProcessor(consoleviewModel.getProcessor());
        console.setPrice(consoleviewModel.getPrice());
        console.setQuantity(consoleviewModel.getQuantity());
        consoleDao.updateConsole(console);
    }

    public void removeConsole(int consoleId) {
        consoleDao.deleteConsole(consoleId);
    }

    public ConsoleViewModel saveConsole(ConsoleViewModel cvm) {
        Console console = new Console();
        console.setConsoleId(cvm.getConsoleId());
        console.setModel(cvm.getModel());
        console.setManufacturer(cvm.getManufacturer());
        console.setMemoryAmount(cvm.getMemoryAmount());
        console.setProcessor(cvm.getProcessor());
        console.setPrice(cvm.getPrice());
        console.setQuantity(cvm.getQuantity());
        console = consoleDao.addConsole(console);
        cvm.setConsoleId(console.getConsoleId());
//        Console console1 = new Console();
//        console.setConsoleId(cvm.getConsoleId());
//        console.setModel(cvm.getModel());
//        console.setManufacturer(cvm.getManufacturer());
//        console.setMemoryAmount(cvm.getMemoryAmount());
//        console.setProcessor(cvm.getProcessor());
//        console.setPrice(cvm.getPrice());
//        console.setQuantity(cvm.getQuantity());
        return cvm;
    }

    public ConsoleViewModel findConsole(int consoleId) {

        Console console = consoleDao.getConsole(consoleId);
        if (console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }


    public List<ConsoleViewModel> findAllConsoles() {
        List<ConsoleViewModel> cvmList = new ArrayList<>();
        List<Console> consoles = consoleDao.getAllConsoles();
        consoles.stream().forEach(console ->
                cvmList.add(buildConsoleViewModel(console)));

        return cvmList;
    }
//    public ConsoleViewModel findConsoleByManufacturer(String manufacturer) {
//        List<Console> console =  consoleDao.getConsoleByManufacturer(manufacturer);
//        if(console == null)
//            return null;
//        else
//            return buildConsoleViewModel(List<Console>,console);
//    }

    //+++++++++++++++++++++Helper methods  BuildViewModels+++++++++++

    private ConsoleViewModel buildConsoleViewModel(Console console) {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setConsoleId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());
        return consoleViewModel;
    }

    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setEsrb(game.getEsrb());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());
        return gameViewModel;
    }

    private TShirtViewModel buildTShirtViewModel(TShirt tshirt) {

        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.settShirtId(tshirt.getTShirtId());
        tShirtViewModel.setSize(tshirt.getSize());
        tShirtViewModel.setColor(tshirt.getColor());
        tShirtViewModel.setDescription(tshirt.getDescription());
        tShirtViewModel.setPrice(tshirt.getPrice());
        tShirtViewModel.setQuantity(tshirt.getQuantity());
        return tShirtViewModel;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipcode(invoice.getZipcode());


        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setQuantity(invoice.getQuantity());

//        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
//
//        invoiceViewModel.setSubtotal(invoice.getSubtotal());
//        invoiceViewModel.setTax(invoice.getTax());
//        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
//        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }


}


