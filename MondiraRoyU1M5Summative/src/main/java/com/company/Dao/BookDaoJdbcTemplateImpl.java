package com.company.Dao;

import com.company.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {

    private JdbcTemplate jdbcTemplate;
//prepared statements
    private static final String INSERT_BOOK_SQL =
            "insert into book (isbn, publish_date, author_id, title, publisher_id, price)" +
                    " values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BOOK_SQL =
            "select * from book where book_id = ?";

    private static final String SELECT_ALL_BOOKS_SQL =
            "select * from book";

    private static final String  SELECT_BOOK_BY_AUTHOR_SQL =
            "select * from book where author_id = ?";

    private static final String UPDATE_BOOK_SQL =
            "update book set isbn = ?, publish_date = ?, runtime = ? where book_id = ?";

    private static final String DELETE_BOOK_SQL =
            "delete from book where book_id =  ?";

    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }


    @Transactional
    public Book addBook(Book book) {
        jdbcTemplate.update(
                INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublishDate().toString(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        book.setBookId(id);

        return book;
    }


    public Book getBook(int id) {

        try {
            return jdbcTemplate.queryForObject(
                    SELECT_BOOK_SQL,
                    this::mapRowToBook,
                    id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no entry with the given id, just return null
            return null;
        }
    }


    public List<Book> getAllBooks() {
        return jdbcTemplate.query(
                SELECT_ALL_BOOKS_SQL,
                this::mapRowToBook);
    }


    public List<Book> getBooksByAuthor(int authorId) {
        return jdbcTemplate.query(
               SELECT_BOOK_BY_AUTHOR_SQL,
                this::mapRowToBook, authorId);

    }


    public void updateBook(Book book) {
        jdbcTemplate.update(
                UPDATE_BOOK_SQL,
                book.getAuthorId(),
                book.getIsbn(),
                book.getTitle(),
                book.getPublishDate().toString(),
                book.getPublisherId(),
                book.getBookId(),
                book.getPrice()  );
    }



    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }



    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setAuthorId(rs.getInt("author_id"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setPrice(rs.getBigDecimal("price"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setTitle(rs.getString("title"));

        return book;
    }
}
