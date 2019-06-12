package com.company;
import java.util.Scanner;


public class ValidNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please Enter a number between 1 and 10.");
        String userInput = myScanner.nextLine();
        int userInt;
        do {
            System.out.println("Enter a number between 1 and 10");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);
        }
        while (userInt< 1 && userInt > 10) ;
        {
            System.out.println("You must enter a number between 1 and 10, please try again");
        }
        System.out.println("Great! You chose " + userInt);

    }
}


