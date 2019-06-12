

package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[5];

        System.out.println("Please enter 5 numbers one by one:");
        for (int i = 0; i < 5; i++) {
            Scanner myscanner= new Scanner(System.in);
            int userInput =Integer.parseInt(myscanner.nextLine());
            input[i] = userInput;
        }

        System.out.println("You have entered: \n" );
        System.out.println(Arrays.toString(input));

    }

}