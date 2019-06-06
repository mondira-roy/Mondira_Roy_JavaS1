package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Please Enter your age");
        int age = myscanner.nextInt();
        if (age < 14) {
            System.out.println("Please enter  your grade");
            int grade = myscanner.nextInt();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        } else if (age <= 18) {
            System.out.println("Do you plan to goto college?(yes/no)");
            Scanner myscan = new Scanner(System.in);
            String s1 = myscan.nextLine();
            //if ( s1=="yes"){
            //int i=Integer.parseInt(s1);
            //boolean b1 = Boolean.parseBoolean(s1);
            if (s1.equals("yes")) {
                System.out.println("which college are you going to?");
                String coll = myscan.nextLine();
                System.out.println(coll + " is a great school!");
            } else if (s1.equals("no")) {
                Scanner myscanner1 = new Scanner(System.in);
                System.out.println("What do you plan to do after high school?");
                String s2 = myscanner1.nextLine();
                System.out.println("Wow, " + s2 + " sounds like a plan!");
            }
        } else if (age > 18) {
            System.out.println("What is your profession?");
            Scanner answer = new Scanner(System.in);
            String prof = answer.nextLine();
            System.out.println(prof + " sounds like a great job!");
        }
    }
}