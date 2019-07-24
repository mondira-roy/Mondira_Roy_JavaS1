package com.example.dao;

import com.example.model.Console;

import java.util.List;

public interface ConsoleDao {

    //Defining the standard CRUD operations to be performed on Console table
    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsole(int id);

    //Defining the additional operation to be performed on Console table
   List<Console> getConsoleByManufacturer(String manufacturer);
}

