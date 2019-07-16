package com.company.Dao;

import com.company.model.Publisher;

import java.util.List;

public interface PublisherDao {
    //CRUD operations on the Publisher table

    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);
}
