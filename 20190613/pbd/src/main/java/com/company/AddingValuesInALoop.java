package com.company;

import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        Scanner myscanner= new Scanner(System.in);
        System.out.println("I will add up the numbers you give me.");
        int count = 0; int input;
        do {
            String inputString = myscanner.nextLine();
            input = Integer.parseInt(inputString);
            count = count + input;
            System.out.println("The number is:  " + input);
            System.out.println("The total so far:  "+ count);
                    } while (input != 0);
        System.out.println("The total is  " + count);

    }



}
