package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.print("Please Enter a number"+ System.lineSeparator());
        int number= myscanner.nextInt();
        //boolean a = number==1;
        if (number % 2 == 0){
            System.out.println("Even number");
        }else{
        System.out.println("Odd number");}
    }
}
