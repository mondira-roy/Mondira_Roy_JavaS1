package com.company.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AppTV {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> TVList;

            TVList = mapper.readValue(new File("televisions.json"),
                    new TypeReference<List<Television>>() {

                    });

                    TVList
                    .stream()
                    .filter(b -> b.getScreenSize() > 60)
                    .forEach(tv-> {
                        System.out.println("===Printing when ScreenSize is more than 60 inches===");
                        System.out.println(" Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Price: " + tv.getPrice());
                        System.out.println("ScreenSize:" + tv.getScreenSize());
                    });
            System.out.println("=====Printing when Mapped by brand====");

            Map<String, List<Television>> mappedbyBrand =
                    TVList
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));

            Set<String> keys = mappedbyBrand.keySet();
            for(String key: keys){
                System.out.println(key);

            }
            System.out.println("==============");
         //   System.out.println("\n\nCalculating average using stream ...");
            double average =
                    TVList
                            .stream()
                            .mapToInt(b -> b.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("Average Screen Size is: " + average);


         //   System.out.println("\n\nCalculating maximum Screen Size ");

            int maxScreenSize =
                    TVList
                            .stream()
                            .mapToInt(b -> b.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("Max SCreenSize: " + maxScreenSize);




        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }

    }
