package com.company;
import java.util.Scanner;
public class CommandLineGram {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your first name");
        String name = myScanner.nextLine();
        System.out.println("Please Enter your last name");
        String lastname = myScanner.nextLine();
        System.out.println("Enter your emailID");
         String email = myScanner.nextLine();
        System.out.println("Enter your Twitter Handle");
            String handle = myScanner.nextLine();
        System.out.println("Enter your Age");
            int age = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter your country");
            String country = myScanner.nextLine();
        System.out.println("Enter your Profession");
            String prof = myScanner.nextLine();
        System.out.println("Enter your favourite operating system");
            String osys = myScanner.nextLine();
        System.out.println("Enter your favourite programming language");
            String lang = myScanner.nextLine();
        System.out.println("Enter your favourite computer scientist");
            String comp_sci = myScanner.nextLine();
        System.out.println("Enter your keyboard shortcut");
            String kb_shortcut = myScanner.nextLine();
        System.out.println("Have you ever built your own computer?(yes/No)");
            String choice = myScanner.nextLine();
        System.out.println("If you could be any superhero, who would it be?");
            String superhero = myScanner.nextLine();
        System.out.format("1. First Name %s \n",name);
        System.out.format("2. Last Name %s \n",lastname);
        System.out.format("3. Email %s \n",email);
        System.out.format("4. Twitter Handle %s \n",handle);
        System.out.format("5. Age %d \n",age);
        System.out.format("6. Country %s \n",country);
        System.out.format("7. Profession %s \n",prof);
        System.out.format("8. Favourite OS %s \n",osys);
        System.out.format("9. Favourite Language %s \n",lang);
        System.out.format("10. Favourite computer scientist %s \n",comp_sci);
        System.out.format("11. Favourite Keyboard Shortcut %s \n",kb_shortcut);
        System.out.format("12. Have you ever built your own computer? %s \n",choice);
        System.out.format("13. Favourite SuperHero %s",superhero);

    }
}
