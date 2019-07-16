package com.company.Dao;


import com.company.model.Book;
import java.util.List;

public interface BookDao {
    //CRUD operations on the book table

    //was getting error in @override. This was caused by addBook(Book book) not implementing method in BookDao

    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    List<Book> getBooksByAuthor(int authorId);

    void updateBook(Book book);

    void deleteBook(int id);
}

