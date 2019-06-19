package com.company.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelevisionReader {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> motoList;

            motoList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            for (Television moto : motoList) {
                System.out.println("================");
                System.out.println(moto.getBrand());
                System.out.println(moto.getModel());
                System.out.println(moto.getPrice());
                System.out.println(moto.getScreenSize());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }
}


