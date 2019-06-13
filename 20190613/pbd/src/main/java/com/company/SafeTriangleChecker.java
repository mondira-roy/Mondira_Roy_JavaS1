package com.company;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class SafeTriangleChecker {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        String inputString1 = myscanner.nextLine();
        int input1 = Integer.parseInt(inputString1);
        String inputString2 = myscanner.nextLine();
        int input2 = Integer.parseInt(inputString2);
        System.out.println("First side is  " + input1);
        System.out.println("Second side is  " + input2);
        while (input1 > input2) {
            System.out.println(input2+ "\tis smaller than " + input1);
            System.out.println("Try Again");
            inputString2 = myscanner.nextLine();
            input2 = Integer.parseInt(inputString2);
            System.out.println("First side is  " + input1);
            System.out.println("Second side is  " + input2);
        }
        String inputString3 = myscanner.nextLine();
        int input3 = Integer.parseInt(inputString3);
        System.out.println("First side is   " + input1);
        System.out.println("Second side is  " + input2);
        System.out.println("Third side is   " + input3);
        while (input2 > input3) {
            System.out.println(input3 + " is smaller than  " + input2);
            System.out.println("Try Again");
            inputString3 = myscanner.nextLine();
            input3 = Integer.parseInt(inputString3);
        }
        System.out.println("Your three sides are \t" + input1 + "\t" + input2 + "\t" + input3);
        System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");

    }
}