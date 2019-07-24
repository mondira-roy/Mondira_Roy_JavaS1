package com.example.dao;

import com.example.model.Game;
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
public class GameDaoJdbcTemplateImplTest {
    @Autowired
    GameDao gameDao;
    @Autowired
    InvoiceDao invoiceDao;


    @Before
    public void setUp() throws Exception {


        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            gameDao.deleteGame(game.getGameId());
        }
    }

    @Test
    public void addgetdeleteGame() {

            Game game = new Game();
            game.setTitle("Game1");
            game.setEsrb("Esrb1");
            game.setDescription("First Game");
            game.setPrice(BigDecimal.valueOf(24.55));
            game.setStudio("Studio1");
            game.setQuantity(1);

            game = gameDao.addGame(game);

            Game game1 = gameDao.getGame(game.getGameId());
            assertEquals(game1,game);

            gameDao.deleteGame(game.getGameId());
            game1 = gameDao.getGame(game.getGameId());
            assertNull(game1);
        }



    @Test
    public void getGame() {
    }

    @Test
    public void getGameByEsrb() {
    }

    @Test
    public void getGameByTitle() {
    }

    @Test
    public void getGameByStudio() {
    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("Game1");
        game.setEsrb("Esrb1");
        game.setDescription("First Game");
        game.setPrice(BigDecimal.valueOf(24.55));
        game.setStudio("Studio1");
        game.setQuantity(1);
        game = gameDao.addGame(game);

         game= new Game();
        game.setTitle("Game2");
        game.setEsrb("Esrb2");
        game.setDescription("Second Game");
        game.setPrice(BigDecimal.valueOf(44.99));
        game.setStudio("Studio2");
        game.setQuantity(5);
        game = gameDao.addGame(game);

        List<Game> gList = gameDao.getAllGames();
        assertEquals(2, gList.size());
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("Game1");
        game.setEsrb("Esrb1");
        game.setDescription("First Game");
        game.setPrice(BigDecimal.valueOf(24.55).setScale(2));
        game.setStudio("Studio1");
        game.setQuantity(1);

        game = gameDao.addGame(game);

//        Updated game table
        game.setTitle("Game2");
        game.setEsrb("Esrb2");
        game.setDescription("Second Game");
        game.setPrice(BigDecimal.valueOf(24.99));
        game.setStudio("Studio2");
        game.setQuantity(5);

        gameDao.updateGame(game);

        Game game1  = gameDao.getGame(game.getGameId());
        assertEquals(game1,game);
    }

}