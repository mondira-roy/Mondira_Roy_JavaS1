package com.company;

import java.util.Random;


public class DiceDoubles {
    public static void main(String[] args) {
        int roll1; int roll2 ;
        do {
            Random rand1 = new Random();
            Random rand2 = new Random();
            roll1 = rand1.nextInt(6);
            roll2 = rand2.nextInt(6);
            int total = roll1 + roll2;
            System.out.println("The Roll #1  " + roll1);
            System.out.println("The Roll #2  " + roll2);
            System.out.println("The total is " + total);
        } while (roll1 != roll2 );

    }
}
