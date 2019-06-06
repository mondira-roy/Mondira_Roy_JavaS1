package com.company;

import java.util.Scanner;

public class YourAgeCan {
    public static void main(String[] args) {
        int age;
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Please Enter your age?");
         String userInput = myscanner.nextLine();
        age = Integer.parseInt(userInput);
        if (age < 18) {
            System.out.println("You cannot vote yet!");
        }else if (age < 21) {
            System.out.println("You cannot drink alcohol yet!");
        }else if (age < 35){
            System.out.println("You cannot be president yet!");
        }else if (age < 55) {
            System.out.println("You cannot have AARP yet!");
        }else if (age < 65) {
            System.out.println("You cannot retire yet!");
        }else if (age >= 80 && age <= 89 ) {
            System.out.println("You are an octogenarian!");
        }else if (age >100) {
            System.out.println("You are more than a century old!");
        }

    }
}