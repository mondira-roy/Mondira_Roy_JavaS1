package com.company;
import java.util.Scanner;
public class SubtractTwo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the first number");
        int num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter another number");
        int num2 = Integer.parseInt(myScanner.nextLine());
        float diff = num1 - num2;
        System.out.format("The difference between your numbers is %.2f", diff);
    }
}
