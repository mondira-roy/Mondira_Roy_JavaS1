package com.company.Dao;

import com.company.model.Author;
import com.company.model.Book;
import com.company.model.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoJdbcTemplateImplTest {

    @Autowired
    protected BookDao bookDao;
    @Autowired
    protected AuthorDao authorDao;
    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db first books
        List<Book> bookList = bookDao.getAllBooks();

        bookList.stream()
                .forEach(book -> bookDao.deleteBook(book.getBookId()));
  //delete the author now
        List<Author> authorList = authorDao.getAllAuthors();

        authorList.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthorId()));

        List<Publisher> pubList = publisherDao.getAllPublishers();

        pubList.stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisherId()));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteBook() {

        // Need to create Publisher and Author first
        Publisher publisher = new Publisher();
        publisher.setName("PName1");
        publisher.setStreet("Pstreet1");
        publisher.setCity("city1");
        publisher.setState("s1");
        publisher.setPostalCode("PCode1");
        publisher.setPhone("Phone1");
        publisher.setEmail("Email1");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("AFName1");
        author.setLastName("ALName1");
        author.setStreet("AStreet1");
        author.setCity("ACity1");
        author.setState("s1");
        author.setPostalCode("APCode1");
        author.setPhone("APhone1");
        author.setEmail("AEmail1");
        author = authorDao.addAuthor(author);

        Book book = new Book();
        book.setTitle("The Big Hit");
        book.setIsbn("Isbn1");
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setPrice(new BigDecimal("21.95"));
        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getBookId());

        assertEquals(book1, book);

        bookDao.deleteBook(book.getBookId());

        book1 = bookDao.getBook(book.getBookId());

        assertNull(book1);
            }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Book book = new Book();
        book.setTitle("Greatest Hits");
        book.setAuthorId(54);
        book.setPublisherId(91);
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setPrice(new BigDecimal("21.95"));

        book = bookDao.addBook(book);

    }

    @Test
    public void updateBook() {

         Need to create a Publisher, Author and Book first
        Publisher publisher = new Publisher();
        publisher.setName("PublisherName1");
        publisher.setStreet("Publisherstreet1");
        publisher.setCity("city1");
        publisher.setState("s1");
        publisher.setPostalCode("Postal_Code1");
        publisher.setPhone("Phone1");
        publisher.setEmail("Email1");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("AuthorFName1");
        author.setLastName("AuthorLName1");
        author.setStreet("AuthorStreet1");
        author.setCity("AuthorCity1");
        author.setState("s1");
        author.setPostalCode("AuthorZip1");
        author.setPhone("AuthorPhone1");
        author.setEmail("AuthorEmail1");
        author = authorDao.addAuthor(author);

        Book book = new Book();
        book.setTitle("The Big Hit");
        book.setIsbn("Isbn1");
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setPrice(new BigDecimal("21.95"));
        book = bookDao.addBook(book);

        book = new Book();
        book.setTitle("NEW TITLE");
        book.setIsbn("Isbn2");
        book.setPublishDate(LocalDate.of(2018, 6, 15));
        book.setPrice(new BigDecimal ("55.99"));

        bookDao.updateBook(book);

        Book book1 = bookDao.getBook(book.getBookId());

        assertEquals(book1, book);

    }

    @Test
    public void getAllBooks() {

        // Need to create a Publisher, Author and Book first
        Publisher publisher = new Publisher();
        publisher.setName("PublisherName1");
        publisher.setStreet("Publisherstreet1");
        publisher.setCity("city1");
        publisher.setState("s1");
        publisher.setPostalCode("Postal_Code1");
        publisher.setPhone("Phone1");
        publisher.setEmail("Email1");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("PublisherName2");
        publisher2.setStreet("Publisherstreet2");
        publisher2.setCity("city2");
        publisher2.setState("s2");
        publisher2.setPostalCode("Postal_Code2");
        publisher2.setPhone("Phone2");
        publisher2.setEmail("Email2");
        publisher2 = publisherDao.addPublisher(publisher2);


        Author author = new Author();
        author.setFirstName("AuthorFName1");
        author.setLastName("AuthorLName1");
        author.setStreet("AuthorStreet1");
        author.setCity("AuthorCity1");
        author.setState("s1");
        author.setPostalCode("AuthorZip1");
        author.setPhone("AuthorPhone1");
        author.setEmail("AuthorEmail1");
        author = authorDao.addAuthor(author);

        Author author2 = new Author();
        author2.setFirstName("AuthorFName2");
        author2.setLastName("AuthorLName2");
        author2.setStreet("AuthorStreet2");
        author2.setCity("AuthorCity2");
        author2.setState("s2");
        author2.setPostalCode("AuthorZip2");
        author2.setPhone("AuthorPhone2");
        author2.setEmail("AuthorEmail2");
        author2 = authorDao.addAuthor(author2);

        Book book = new Book();
        book.setTitle("First Lady");
        book.setIsbn("Isbn1");
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setPrice(new BigDecimal("21.95"));
        book = bookDao.addBook(book);

        Book book1 = new Book();
        book1.setTitle("Second Lady");
        book1.setIsbn("Isbn2");
        book1.setAuthorId(author2.getAuthorId());
        book1.setPublisherId(publisher2.getPublisherId());
        book1.setPublishDate(LocalDate.of(2010, 1, 5));
        book1.setPrice(new BigDecimal("21.95"));
        book1 = bookDao.addBook(book1);

        List<Book> bookList = bookDao.getAllBooks();

        assertEquals(bookList.size(), 2);

    }

    @Test
    public void getBooksByAuthor() {

        // Need to create a Label, Artist, and Album first
        Publisher publisher = new Publisher();
        publisher.setName("PublisherName1");
        publisher.setStreet("Publisherstreet1");
        publisher.setCity("city1");
        publisher.setState("s1");
        publisher.setPostalCode("Postal_Code1");
        publisher.setPhone("Phone1");
        publisher.setEmail("Email1");
        publisher = publisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("AuthorFName1");
        author.setLastName("AuthorLName1");
        author.setStreet("AuthorStreet1");
        author.setCity("AuthorCity1");
        author.setState("s1");
        author.setPostalCode("AuthorZip1");
        author.setPhone("AuthorPhone1");
        author.setEmail("AuthorEmail1");
        author = authorDao.addAuthor(author);

        Author author2 = new Author();
        author2.setFirstName("AuthorFName2");
        author2.setLastName("AuthorLName2");
        author2.setStreet("AuthorStreet2");
        author2.setCity("AuthorCity2");
        author2.setState("s2");
        author2.setPostalCode("AuthorZip2");
        author2.setPhone("AuthorPhone2");
        author2.setEmail("AuthorEmail2");
        author2 = authorDao.addAuthor(author2);


        Book book = new Book();

        book.setIsbn("Isbn");
        book.setPublishDate(LocalDate.of(2018, 3, 25));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Big Bang Theory");
        book.setPublisherId(publisher.getPublisherId());
        book.setPublishDate(LocalDate.of(2010, 1, 5));
        book.setPrice(new BigDecimal("21.95"));

        book = bookDao.addBook(book);

        Book book1 = new Book();

        book1.setIsbn("Isbn1");
        book1.setAuthorId(author2.getAuthorId());
        book1.setTitle("The Bigger Fool");
        book1.setPublisherId(publisher.getPublisherId());
        book1.setPublishDate(LocalDate.of(2010, 1, 5));
        book1.setPrice(new BigDecimal("21.95"));

        book1 = bookDao.addBook(book1);

        Book book2 = new Book();

        book2.setIsbn("Isbn2");
        book2.setAuthorId(author2.getAuthorId());
        book2.setTitle("The Biggest Mistake");
        book2.setPublisherId(publisher.getPublisherId());
        book2.setPublishDate(LocalDate.of(2010, 1, 5));
        book2.setPrice(new BigDecimal("21.95"));

        book2 = bookDao.addBook(book2);

        List<Book> tList = bookDao.getBooksByAuthor(author.getAuthorId());
        assertEquals(tList.size(), 1);

        tList = bookDao.getBooksByAuthor(author2.getAuthorId());
        assertEquals(tList.size(), 2);
    }

}


