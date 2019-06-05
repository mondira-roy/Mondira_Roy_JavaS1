package com.company;
import java.util.Scanner;
public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int num1 = Integer.parseInt(myScanner.nextLine());
        float add_double = (num1 + 5) *2f;

        System.out.format("The new numbers is %.2f", add_double);
    }
}
