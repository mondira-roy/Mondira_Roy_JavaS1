package com.example.dao;


import com.example.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

 @Repository
 public class TShirtDaoJdbcTemplateImpl implements TShirtDao {
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_TSHIRT_SQL =
                "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_TSHIRT_SQL =
                "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_TSHIRTBYCOLOR_SQL =
                "select * from t_shirt where color = ?";

    private static final String SELECT_TSHIRTBYSIZE_SQL =
                "select * from t_shirt where size = ?";

    private static final String SELECT_ALL_TSHIRTS_SQL =
                "select * from t_shirt ";

    private static final String UPDATE_TSHIRT_SQL =
                "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

        private static final String DELETE_TSHIRT =
                "delete from t_shirt where t_shirt_id = ?";

        @Autowired
        public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        @Transactional
        public TShirt addTShirt(TShirt tshirt) {
            jdbcTemplate.update(
                    INSERT_TSHIRT_SQL,
                    tshirt.getSize(),
                    tshirt.getColor(),
                    tshirt.getDescription(),
                    tshirt.getPrice(),
                    tshirt.getQuantity());

            int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

            tshirt.setTShirtId(id);

            return tshirt;
        }

        @Override
        public TShirt getTShirt(int id) {
            try {
                return jdbcTemplate.queryForObject(SELECT_TSHIRT_SQL, this::mapRowToTShirt, id);
            } catch (EmptyResultDataAccessException e) {
                // if there is no match for this console id, return null
                return null;
            }
        }
        @Override
        public List<TShirt> getTShirtByColor(String color) {
            try {
                return jdbcTemplate.query(SELECT_TSHIRTBYCOLOR_SQL, this::mapRowToTShirt, color);
            } catch (EmptyResultDataAccessException e) {
                // if there is no match for this console manufacturer, return null
                return null;
            }
        }
        @Override
        public List<TShirt> getTShirtBySize(String size) {
            try {
                return jdbcTemplate.query(SELECT_TSHIRTBYSIZE_SQL, this::mapRowToTShirt, size);
            } catch (EmptyResultDataAccessException e) {
                // if there is no match for this console manufacturer, return null
                return null;
            }
        }

        @Override
        public List<TShirt> getAllTShirts() {

            return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapRowToTShirt);
        }

        @Override
        public void updateTShirt(TShirt tshirt) {
            jdbcTemplate.update(
                    UPDATE_TSHIRT_SQL,
                    tshirt.getSize(),
                    tshirt.getColor(),
                    tshirt.getDescription(),
                    tshirt.getPrice(),
                    tshirt.getQuantity(),
                    tshirt.getTShirtId()
            );

        }

        @Override
        @Transactional
        public void deleteTShirt(int id) {

            jdbcTemplate.update(DELETE_TSHIRT, id);
        }

        private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
            TShirt tshirt = new TShirt();

            tshirt.setTShirtId(rs.getInt("t_shirt_id"));
            tshirt.setSize(rs.getString("size"));
            tshirt.setColor(rs.getString("color"));
            tshirt.setDescription(rs.getString("description"));
            tshirt.setPrice(rs.getBigDecimal("price"));
            tshirt.setQuantity(rs.getInt("quantity"));

            return tshirt;
        }


    }

