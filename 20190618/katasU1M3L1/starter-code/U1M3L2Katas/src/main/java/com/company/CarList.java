package com.company;

import java.util.*;

public class CarList {
    public CarList() {
    }

    public static void main(String[] args) {
        Map<String, Integer> cars = new HashMap<>();

  //Calling the methods
        mapFun();
        listCars();

    }

    private static void mapFun() {
        Map<String, Integer> cars = new HashMap<>();
        //creating map entries
        cars.put("Toyota Camry ", 2012);
        cars.put("Chevy Camaro ", 1969);
        cars.put("Hyundai Genesis", 2015);
        cars.put("Jeep Wrangler", 2003);
        cars.put("Honda Civic ", 2018);
        cars.put("Toyota Supra", 1995);
        cars.put("Pontiac GTO ", 1964);

//updating cars List
        cars.put("Ford Explorer", 2012);
        cars.put("Smart Fortwo", 2013);

        //Removing an entry
        cars.remove("Jeep Wrangler");

        Set<String> myKeys = cars.keySet();
        //Set<Integer> myValues= cars.values();
        myKeys = cars.keySet();
        for (String key : myKeys) {
            System.out.println("Key:\t" + key + "\t Value: \t" + cars.get(key));
        }
    }

    public static void listCars() {
        List<Car> toyotaList = new ArrayList<>();
        System.out.println(" List : " + toyotaList);
        toyotaList.add("toyota", "Camry");
        toyotaList.add("toyota", "Prius");
        toyotaList.add("toyota", "High Lander");
        System.out.println(toyotaList);

        List<Car> fordList = new ArrayList<>();
        fordList.add("Ford", "Focus");
        fordList.add("Ford", "camarro");
        fordList.add("Ford", "High Lander");
        System.out.println(fordList);

        List<Car> hondaList = new ArrayList<>();
        hondaList.add("Honda", "Odyssey");
        hondaList.add("Honda", "Civic");
        hondaList.add("Honda", "Pilot");
        System.out.println(hondaList);
    }

}

