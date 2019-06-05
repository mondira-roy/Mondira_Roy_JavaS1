package com.company;
import java.util.Scanner;
public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int num1 = Integer.parseInt(myScanner.nextLine());
        float num2 = (num1*2f)+5f;
        System.out.format("The new number is %.2f", num2);
    }
}
