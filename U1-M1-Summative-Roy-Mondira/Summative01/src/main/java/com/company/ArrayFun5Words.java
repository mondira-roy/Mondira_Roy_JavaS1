package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {

        // taking String array input from user
        Scanner sc = new Scanner(System.in);
        String[] input = new String[5];

        // loop over array to save user input
        System.out.println("Please enter 5 words");
        for (int i = 0; i < 5; i++) {
            String userInput = sc.next();
            input[i] = userInput;
        }

        System.out.println("The String array input from user is : ");
        System.out.println(Arrays.toString(input));

    }
}


