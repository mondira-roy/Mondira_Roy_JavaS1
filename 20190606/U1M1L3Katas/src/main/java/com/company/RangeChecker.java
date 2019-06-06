
package com.company;
import java.util.Scanner;
public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userInt;
        do {
            System.out.println("Enter a number between 15 and 32");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);
            }
            while (userInt> 15 && userInt < 32) ;
            {
                System.out.println("Try again");
            }
            System.out.println("Great! You chose " + userInt);

        }
    }