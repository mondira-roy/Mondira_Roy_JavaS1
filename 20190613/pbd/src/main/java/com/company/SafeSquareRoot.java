package com.company;
import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        System.out.println(" SQUARE  ROOT \n");
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String inputString1 = myscanner.nextLine();
        int input = Integer.parseInt(inputString1);
        double val = Math.sqrt(input);
        System.out.println("The Square root of  " + input + "is  \n" + val);
        do {
            int Input = myscanner.nextInt();
            double val = Math.sqrt(Input);
            System.out.println("The Square root of  " + Input + "is  \n" + val);
        }
        while (input < 0);{
            System.out.println("You can't take Square root of a negative number, Silly!");
            System.out.println(" Try Again");
        }

    }

    }
