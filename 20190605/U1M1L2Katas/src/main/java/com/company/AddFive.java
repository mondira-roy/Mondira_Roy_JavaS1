package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter first number");
        int num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter second number");
        int num2 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter third number");
        int num3 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter fourth number");
        int num4 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter fifth number");
        int num5 = Integer.parseInt(myScanner.nextLine());
        float sum= num1+num2+num3+num4+num5;
        System.out.format("The sum of 5 numbers is %.2f", sum);
    }
}
