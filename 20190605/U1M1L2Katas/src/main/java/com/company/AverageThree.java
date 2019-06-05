package com.company;
import java.util.Scanner;
public class AverageThree {

    public static void main(String[] args) {

            Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the first number");
        int number1 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter the second number");
        int number2 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter the third number");
        int number3 = Integer.parseInt(myScanner.nextLine());

        float average = (number1 + number2 + number3) / 3f;

        System.out.format("The average of your numbers is %.2f", average);

    }

}
