package com.company;
import java.util.Scanner;
public class AddThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int num1 = Integer.parseInt(myScanner.nextLine());
        float add_thirteen = (num1 + 13);
        System.out.format("The new number is %.2f", add_thirteen);

    }
}
