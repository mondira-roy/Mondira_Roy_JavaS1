package com.company.Dao;

import com.company.model.Author;
import java.util.List;

public interface AuthorDao {
    //CRUD operations on the Author table

    Author addAuthor(Author author);

    Author getAuthor(int id);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(int id);
}

