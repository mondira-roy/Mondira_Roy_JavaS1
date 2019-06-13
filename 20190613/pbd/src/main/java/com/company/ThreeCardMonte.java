package com.company;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        System.out.println("You slide up to Fast Eddie's card table " +
                        "and plop down your cash.\n");
        System.out.println("He glances at you out of the corner of his eye " +
                "and starts shuffling.");
        System.out.println("He lays down three cards.");
        System.out.println("Which one is the ace?");
        Random rand = new Random();
        int ace = rand.nextInt(3);
        Scanner myscanner= new Scanner(System.in);
         int userInput = Integer.parseInt(myscanner.nextLine());

        System.out.println("##" + "\t"+ "##" + "\t" + "##");
        System.out.println("##" + "\t"+ "##" + "\t" + "##");
        System.out.println( 1 + "\t"+ 2 + "\t" + 3 );
        boolean check = (ace == userInput);
        switch(ace){
            case 1:
                System.out.println("AA" + "\t"+ "##" + "\t" + "##");
                System.out.println("AA" + "\t"+ "##" + "\t" + "##");
                System.out.println(userInput);
                if(check = true){
                    System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
                } else {
                    System.out.println("Ha! Fast Eddie wins again! The ace was card number 1 ");
                }break;
            case 2:
                System.out.println("##" + "\t"+ "AA" + "\t" + "##");
                System.out.println("##" + "\t"+ "AA" + "\t" + "##");
                System.out.println(userInput);
                if(check = true){
                    System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
                } else {
                    System.out.println("Ha! Fast Eddie wins again! The ace was card number 2 ");
                }break;
            case 3:
                System.out.println("##" + "\t"+ "##" + "\t" + "AA");
                System.out.println("##" + "\t"+ "##" + "\t" + "AA");
                System.out.println(userInput);
                if(check = true){
                    System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
                }else {
                    System.out.println("Ha! Fast Eddie wins again! The ace was card number 3 ");
                }break;
                default:

        }
    }
}
