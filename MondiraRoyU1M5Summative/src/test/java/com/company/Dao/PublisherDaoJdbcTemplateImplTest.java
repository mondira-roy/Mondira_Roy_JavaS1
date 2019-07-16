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
public class PublisherDaoJdbcTemplateImplTest {

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
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("PName");
        publisher.setStreet("PStreet");
        publisher.setCity("PCity");
        publisher.setState("PS");
        publisher.setPostalCode("PPCode");
        publisher.setPhone("PPhone");
        publisher.setEmail("PEmail");
        // publisher.setPublisherId("publisherId1");
        publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getPublisherId());

        publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        assertNull(publisher1);

    }

    @Test
    public void getAllPublishers() {

        Publisher publisher = new Publisher();
        publisher.setName("PName1");
        publisher.setStreet("PStreet1");
        publisher.setCity("PC1");
        publisher.setState("S1");
        publisher.setPostalCode("PPCode1");
        publisher.setPhone("PPhone1");
        publisher.setEmail("PEmail1");
        publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("PName2");
        publisher.setStreet("PStreet2");
        publisher.setCity("PC2");
        publisher.setState("S2");
        publisher.setPostalCode("PPCode2");
        publisher.setPhone("PPhone2");
        publisher.setEmail("PEmail2");
        publisherDao.addPublisher(publisher);

        List<Publisher> pList = publisherDao.getAllPublishers();

        assertEquals(pList.size(), 2);

    }

    @Test
    public void updatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("PName3");
        publisher.setStreet("PStreet3");
        publisher.setCity("PC3");
        publisher.setState("S3");
        publisher.setPostalCode("PPCode3");
        publisher.setPhone("PPhone3");
        publisher.setEmail("PEmail3");

        publisherDao.addPublisher(publisher);

        publisher.setName("PName4");
        publisher.setEmail("PEmail4");
        publisher.setCity("PC4");
        publisher.setState("S4");
        publisher.setPostalCode("PPCode4");
        publisher.setPhone("PPhone4");
        publisher.setStreet("PublisherStreet4");


        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals(publisher1, publisher);
    }
}