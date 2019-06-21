package com.company;

import com.company.interfaces.Converter;

public class ConverterApplication {
    public static void main(String[] args) {
     // Instantiating

        Converter if1 = new ConverterIf();
        Converter switch1= new ConverterSwitch();

        // Testing for Month and Day
        if1.convertDay(4);
        switch1.convertDay(7);
        switch1.convertMonth(4);
        if1.convertMonth(6);
    }
}
