package com.example.dao;

import com.example.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


 @Repository
 public class GameDaoJdbcTemplateImpl implements GameDao {
     private JdbcTemplate jdbcTemplate;

     private static final String INSERT_GAME_SQL =
              "insert into game (title, esrb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?, ?)";

     private static final String SELECT_GAME_SQL =
                "select * from game where game_id = ?";

     private static final String SELECT_GAMEBYTITLE_SQL =
             "select * from game where title = ?";

     private static final String SELECT_GAMEBYSTUDIO_SQL =
             "select * from game where studio = ?";

     private static final String SELECT_GAMEBYESRB_SQL =
             "select * from game where esrb_rating = ?";

     private static final String SELECT_ALL_GAMES_SQL =
                "select * from game ";

     private static final String UPDATE_GAME_SQL =
                "update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";

        private static final String DELETE_GAME =
                "delete from game where game_id = ?";

        @Autowired
        public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        @Transactional
        public Game addGame(Game game) {
            jdbcTemplate.update(
                    INSERT_GAME_SQL,
                    game.getTitle(),
                    game.getEsrb(),
                    game.getDescription(),
                    game.getPrice(),
                    game.getStudio(),
                    game.getQuantity());

            int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

            game.setGameId(id);

            return game;
        }

        @Override
        public Game getGame(int id) {
            try {
                return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
            } catch (EmptyResultDataAccessException e) {
                // if there is no match for this game id, return null
                return null;
            }
        }
        @Override
        public List<Game> getGameByEsrb(String esrb) {
            try {
                return jdbcTemplate.query(SELECT_GAMEBYESRB_SQL, this::mapRowToGame, esrb);
            } catch (EmptyResultDataAccessException e) {
                // if there is no match for this Esrb Rating, return null
                return null;
            }
        }
     @Override
     public List<Game> getGameByTitle(String title) {
         try {
             return jdbcTemplate.query(SELECT_GAMEBYTITLE_SQL, this::mapRowToGame, title);
         } catch (EmptyResultDataAccessException e) {
             // if there is no match for this game title, return null
             return null;
         }
     }
     @Override
     public List<Game> getGameByStudio(String studio) {
         try {
             return jdbcTemplate.query(SELECT_GAMEBYSTUDIO_SQL, this::mapRowToGame, studio);
         } catch (EmptyResultDataAccessException e) {
             // if there is no match for this game studio, return null
             return null;
         }
     }

        @Override
        public List<Game> getAllGames() {

            return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
        }

        @Override
        public void updateGame(Game game) {
            jdbcTemplate.update(
                    UPDATE_GAME_SQL,
                    game.getTitle(),
                    game.getEsrb(),
                    game.getDescription(),
                    game.getPrice(),
                    game.getStudio(),
                    game.getQuantity(),
                    game.getGameId()
            );

        }

        @Override
        @Transactional
        public void deleteGame(int id) {

            jdbcTemplate.update(DELETE_GAME, id);
        }

        private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
            Game game = new Game();

            game.setGameId(rs.getInt("game_id"));
            game.setTitle(rs.getString("title"));
            game.setEsrb(rs.getString("esrb_rating"));
            game.setDescription(rs.getString("description"));
            game.setPrice(rs.getBigDecimal("price"));
            game.setStudio(rs.getString("studio"));
            game.setQuantity(rs.getInt("quantity"));

            return game;
        }


    }


