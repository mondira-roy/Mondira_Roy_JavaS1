package com.example.dao;

import com.example.model.TShirt;

import java.util.List;

public interface TShirtDao {
//Defining the standard CRUD operations to be performed on TShirt table

    TShirt addTShirt(TShirt tshirt);

    TShirt getTShirt(int id);

    List<TShirt> getAllTShirts();

    void updateTShirt(TShirt tshirt);

    void deleteTShirt(int id);


//Defining the additional operations to be performed on T-Shirt table

    List<TShirt> getTShirtByColor(String color);

    List<TShirt> getTShirtBySize(String size);


}
