package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your favourite programming language?");
        String userInput1 = myScanner.nextLine();
        // enter the while loop if the user typed in 'Java'
        do {
            System.out.println("What is your favourite programming language?");
            String userInput = myScanner.nextLine();
            if (userInput.equals(userInput1)) {
                System.out.println("That's what I was looking for! Java is definitely the answer!");
            } else {
                System.out.println(" Please try again?");
            }
            //userInput1 = myScanner.nextLine();
        } while (userInput1.equals("Java"));
        {
            System.out.println("That's what I was looking for! Java is definitely the answer!");
        }
    }
}