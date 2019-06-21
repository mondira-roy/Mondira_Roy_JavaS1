package com.company;

import com.company.interfaces.Converter;

public class ConverterIf implements Converter {

    public String convertDay(int day) {
        int userDay = day;
        if (userDay == 1) {
            System.out.println("Sunday");
        } else if (userDay == 2) {
            System.out.println("Monday");
        } else if (userDay == 3) {
            System.out.println("Tuesday");
        } else if (userDay == 4) {
            System.out.println("Wednesday");
        } else if (userDay == 5) {
            System.out.println("Thursday");
        } else if (userDay == 6) {
            System.out.println("Friday");
        } else if (userDay == 7) {
            System.out.println("Saturday");
        } else {
           // System.out.println("You have entered an invalid number. " +
            //        "You must enter a number between 1 and 7. Goodbye.");
        }return "";
    }

    public String convertMonth(int month) {
        int userMonth = month;
        {
            if (userMonth == 1) {
                System.out.println("January");
            } else if (userMonth == 2) {
                System.out.println("February");
            } else if (userMonth == 3) {
                System.out.println("March");
            } else if (userMonth == 4) {
                System.out.println("April");
            } else if (userMonth == 5) {
                System.out.println("May");
            } else if (userMonth == 6) {
                System.out.println("June");
            } else if (userMonth == 7) {
                System.out.println("July");
            } else if (userMonth == 8) {
                System.out.println("August");
            } else if (userMonth == 9) {
                System.out.println("September");
            } else if (userMonth == 10) {
                System.out.println("October");
            } else if (userMonth == 11) {
                System.out.println("November");
            } else if (userMonth == 12) {
                System.out.println("December");
            }
            //System.out.println("You have entered an invalid number. " +
             //       "You must enter a number between 1 and 12. Goodbye.");
        }
        return "";
    }

}
