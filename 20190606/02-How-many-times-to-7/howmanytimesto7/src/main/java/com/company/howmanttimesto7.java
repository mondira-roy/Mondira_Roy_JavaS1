package com.company;
import java.util.Random;
import java.util.Scanner;

public class howmanttimesto7 {
        public static void main(String[] args) {
            Scanner myScanner = new Scanner(System.in);
            Random rand = new Random();

            System.out.println("Enter the number of dice_rolls:");
            int dice = Integer.parseInt(myScanner.nextLine());

            int max = 12;int min = 2;int two = 0;
            int three = 0;int four = 0;int five = 0;
            int six = 0;int seven = 0;int eight = 0;int nine = 0;
            int ten = 0;int eleven = 0;int twelve = 0;

            boolean Roll7 = false;
            for (int i = 0; i < dice; i++ ) {
                int random = rand.nextInt((max - min) + 1) + min;
                switch (random) {
                    case 2:
                        two++;
                        break;
                    case 3:
                        three++;
                        break;
                    case 4:
                        four++;
                        break;
                    case 5:
                        five++;
                        break;
                    case 6:
                        six++;
                        break;
                    case 7:
                        if (Roll7 == false) {
                            System.out.println("It took you " + i + " rolls to get 7");
                            Roll7 = true;
                        }
                        seven++;
                        break;
                    case 8:
                        eight++;
                        break;
                    case 9:
                        nine++;
                        break;
                    case 10:
                        ten++;
                        break;
                    case 11:
                        eleven++;
                        break;
                    case 12:
                        twelve++;
                        break;
                }
            }
            System.out.println("You rolled " + dice + " times");
            System.out.println("You rolled 2 " + two + " times" );
            System.out.println("You rolled 3 " + three + " times" );
            System.out.println("You rolled 4 " + four + " times" );
            System.out.println("You rolled 5 " + five + " times" );
            System.out.println("You rolled 6 " + six + " times" );
            System.out.println("You rolled 7 " + seven + " times" );
            System.out.println("You rolled 8 " + eight + " times" );
            System.out.println("You rolled 9 " + nine + " times" );
            System.out.println("You rolled 10 " + ten + " times" );
            System.out.println("You rolled 11 " + eleven + " times" );
            System.out.println("You rolled 12 " + twelve + " times" );
        }
    }

