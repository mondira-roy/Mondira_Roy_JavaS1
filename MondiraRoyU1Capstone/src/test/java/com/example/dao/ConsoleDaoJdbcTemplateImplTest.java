package com.example.dao;

import com.example.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {
    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    TShirtDao tShirtDao;
    @Autowired
    SalesTaxRateDao salesTaxRateDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console con : consoles) {
            consoleDao.deleteConsole(con.getConsoleId());
        }

//
   }
    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("Model1");
        console.setManufacturer("Manufacturer1");
        console.setMemoryAmount("MemoryAmount1");
        console.setProcessor("Processor1");
        console.setPrice(BigDecimal.valueOf(125.99));

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getConsoleId());
        console1 = consoleDao.getConsole(console.getConsoleId());
        //assertNull(console1);
    }

    @Test
    public void getConsoleByManufacturer() {
       Console console = new Console();
        console.setConsoleId(1);
        console.setModel("Model1");
        console.setManufacturer("Manufacturer1");
        console.setMemoryAmount("MemoryAmount1");
        console.setProcessor("Processor1");
        console.setPrice(BigDecimal.valueOf(125.99));
       consoleDao.addConsole(console);

         Console console1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console1, console);
    }

    @Test
    public void getAllConsoles() {
        Console console = new Console();
        console.setModel("Model1");
        console.setManufacturer("Manufacturer1");
        console.setMemoryAmount("MemoryAmount1");
        console.setProcessor("Processor1");
        console.setPrice(BigDecimal.valueOf(125.99));

        console = consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Model2");
        console.setManufacturer("Manufacturer2");
        console.setMemoryAmount("MemoryAmount2");
        console.setProcessor("Processor2");
        console.setPrice(BigDecimal.valueOf(250.99));
        console = consoleDao.addConsole(console);

        List<Console> cList = consoleDao.getAllConsoles();
        assertEquals(2, cList.size());


    }
    @Test
    public void updateConsole() {

        Console console = new Console();
        console.setModel("John");
        console.setManufacturer("Doe");
        console.setMemoryAmount("johndoe@gmail.com");
        console.setProcessor("Trilogy");
        console.setPrice(BigDecimal.valueOf(23.55));
        console.setQuantity(2);
    console = consoleDao.addConsole(console);

       // console = new Console();
        console.setModel("John1");
        console.setManufacturer("Doe1");
        console.setMemoryAmount("johndoe1@gmail.com");
        console.setProcessor("Trilogy1");
        console.setPrice(BigDecimal.valueOf(55.99));
        console.setQuantity(5);

        consoleDao.updateConsole(console);

        Console console1  = consoleDao.getConsole(console.getConsoleId());
         assertEquals(console1,console);
}



}