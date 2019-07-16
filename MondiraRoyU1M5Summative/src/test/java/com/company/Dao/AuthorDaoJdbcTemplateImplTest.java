package com.company.Dao;

import com.company.model.Author;
import com.company.model.Book;
import com.company.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoJdbcTemplateImplTest {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;


    @Before
    public void setUp() throws Exception {
        // Clean up the test db

        List<Book> bList = bookDao.getAllBooks();

        for (Book b : bList) {
            bookDao.deleteBook(b.getBookId());
        }

        List<Publisher> pubList = publisherDao.getAllPublishers();
        for (Publisher p : pubList) {
            publisherDao.deletePublisher(p.getPublisherId());
        }

        List<Author> autList = authorDao.getAllAuthors();

        for (Author a : autList) {
            authorDao.deleteAuthor(a.getAuthorId());
        }

    }

    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();
        author.setFirstName("FName");
        author.setLastName("LName");
        author.setStreet("AStreet");
        author.setCity("ACity");
        author.setState("AS");
        author.setPostalCode("APCode");
        author.setPhone("APhone");
        author.setEmail("AEmail");

        authorDao.addAuthor(author);

        Author author1 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author1, author);

        authorDao.deleteAuthor(author.getAuthorId());

        author1 = authorDao.getAuthor(author.getAuthorId());

        assertNull(author1);

    }

    @Test
    public void getAllAuthors() {

        Author author = new Author();
        author.setFirstName("FName1");
        author.setLastName("LName1");
        author.setStreet("AStreet1");
        author.setCity("ACity1");
        author.setState("S1");
        author.setPostalCode("APCode1");
        author.setPhone("APhone");
        author.setEmail("AEmail1");
        authorDao.addAuthor(author);

        author = new Author();
        author.setFirstName("FName2");
        author.setLastName("LName2");
        author.setStreet("AStreet2");
        author.setCity("ACity2");
        author.setState("S2");
        author.setPostalCode("APCode2");
        author.setPhone("APhone2");
        author.setEmail("AEmail2");
        authorDao.addAuthor(author);

        List<Author> aList = authorDao.getAllAuthors();

        assertEquals(aList.size(), 2);

    }

    @Test
    public void updateAuthor() {

        Author author = new Author();
        author.setFirstName("FName3");
        author.setLastName("LName3");
        author.setStreet("AStreet3");
        author.setCity("ACity3");
        author.setState("S3");
        author.setPostalCode("APCode3");
        author.setPhone("APhone3");
        author.setEmail("AEmail3");
        authorDao.addAuthor(author);

        author.setFirstName("AFName4");
        author.setLastName("ALName4");
        author.setStreet("AStreet4");
        author.setCity("ACity4");
        author.setState("S4");
        author.setPostalCode("APCode4");
        author.setPhone("APhone4");
        author.setEmail("AEmail4");
        authorDao.updateAuthor(author);

        Author author1 = authorDao.getAuthor(author.getAuthorId());

        assertEquals(author1, author);
    }
}