package com.company;
import java.lang.Boolean;

public class FizzBuzz {
    public static void main(String[] args) {
        for (int num = 1; num <= 100; num++) {
            //Boolean number3 ; Boolean number5;
            if(num % 15 == 0) {
                System.out.println("FIZZBUZZ");
            }else if(num % 3 == 0) {
                    System.out.println("FIZZ");
            } else if (num % 5 == 0) {
                System.out.println("BUZZ");
            } else {
                System.out.println(num);
            }
        }
    }
}
