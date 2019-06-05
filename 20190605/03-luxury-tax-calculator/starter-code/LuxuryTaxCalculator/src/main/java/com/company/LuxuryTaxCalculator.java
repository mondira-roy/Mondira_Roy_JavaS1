package com.company;
import java.util.Scanner;
public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter salary for first player");
        int sal1 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter salary for second player");
        int sal2 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter salary for third player");
        int sal3 = Integer.parseInt(myScanner.nextLine());
        float total= sal1+sal2+sal3;
        System.out.format("The total salary is= $ %.2f\n", total);
        if (total>40000000) {
            float tax = total - 40000000f;
            float percent_tax = 0.18f * tax;
            System.out.format("The Luxury tax is = $ %.2f \n", percent_tax);
        }
        else
            System.out.println("There is no luxury tax");
    }
}
