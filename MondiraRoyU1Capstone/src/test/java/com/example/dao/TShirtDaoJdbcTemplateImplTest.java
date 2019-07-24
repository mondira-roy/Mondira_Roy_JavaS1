package com.example.dao;

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
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoJdbcTemplateImplTest {
    @Autowired
    TShirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {
        List<TShirt> tShirts = tshirtDao.getAllTShirts();

        for (TShirt t : tShirts) {
            tshirtDao.deleteTShirt(t.getTShirtId());
        }
    }
    @Test
    public void addGetDeleteTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Red");
        tShirt.setDescription("Polo");
        tShirt.setPrice(BigDecimal.valueOf(14.55).setScale(2));
        tShirt.setQuantity(4);

        tShirt = tshirtDao.addTShirt(tShirt);

        TShirt tShirt1 = tshirtDao.getTShirt(tShirt.getTShirtId());
        assertEquals(tShirt, tShirt1);

            tshirtDao.deleteTShirt(tShirt.getTShirtId());
        tShirt1 = tshirtDao.getTShirt(tShirt.getTShirtId());
        assertNull(tShirt1);
    }

    @Test
    public void getTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Red");
        tShirt.setDescription("Polo");
        tShirt.setPrice(BigDecimal.valueOf(14.55).setScale(2));
        tShirt.setQuantity(4);

        tShirt = tshirtDao.addTShirt(tShirt);
        TShirt tShirt1 = tshirtDao.getTShirt(tShirt.getTShirtId());
        assertEquals(tShirt, tShirt1);
    }

    @Test
    public void testGetTShirtByColor() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Red");
        tShirt.setDescription("Polo");
        tShirt.setPrice(BigDecimal.valueOf(14.55).setScale(2));
        tShirt.setQuantity(4);

        tShirt = tshirtDao.addTShirt(tShirt);
        List<TShirt> tList= tshirtDao.getTShirtByColor("Red");
        assertEquals(tList.size(), 1);
    }

    @Test
    public void getTShirtBySize() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Red");
        tShirt.setDescription("Polo");
        tShirt.setPrice(BigDecimal.valueOf(14.55).setScale(2));
        tShirt.setQuantity(4);

        tShirt = tshirtDao.addTShirt(tShirt);

        List<TShirt> tList= tshirtDao.getTShirtBySize(tShirt.getSize());
        assertEquals(tList.size(), 1);
    }


    @Test
    public void getAllTShirts() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Large");
        tShirt.setColor("Red");
        tShirt.setDescription("Polo");
        tShirt.setPrice(BigDecimal.valueOf(14.55));
        tShirt.setQuantity(4);
        tShirt = tshirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("Large");
        tShirt.setColor("Red");
        tShirt.setDescription("Polo");
        tShirt.setPrice(BigDecimal.valueOf(14.55));
        tShirt.setQuantity(4);
        tShirt = tshirtDao.addTShirt(tShirt);


        List<TShirt> tList = tshirtDao.getAllTShirts();
        assertEquals(2, tList.size());
    }

    @Test
    public void updateTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Red");
        tShirt.setDescription("Polo");
        tShirt.setPrice(BigDecimal.valueOf(14.55).setScale(2));
        tShirt.setQuantity(4);

         tshirtDao.addTShirt(tShirt);
        List<TShirt> tList = tshirtDao.getAllTShirts();
        assertEquals(1, tList.size());

         tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Red");
        tShirt.setDescription("TurtleNeck");
        tShirt.setPrice(BigDecimal.valueOf(34.55).setScale(2));
        tShirt.setQuantity(10);

        tshirtDao.addTShirt(tShirt);
        tList = tshirtDao.getAllTShirts();
        assertEquals(2, tList.size());
    }


}