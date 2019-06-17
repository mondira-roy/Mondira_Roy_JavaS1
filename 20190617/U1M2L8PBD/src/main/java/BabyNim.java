import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
                //initialize counter
        String A;
        String B;
        String C;
        String a;
        String b;
        String c;
        boolean check = true;
        int numA=3;
        int numB=3;
        int numC=3;

       //input value
        Scanner myscanner = new Scanner(System.in);
        System.out.println("A: \t"+ numA + "\t"+ "B: \t"+ numB + "\t"+ "C: \t" + numC);

        while( check ) {
            System.out.println("Please pick a pile. ");
            String pile = myscanner.nextLine();
            switch (pile) {
                case "A":
                case "a":
                    System.out.println("How many to remove from Pile A");
                    int usernumberA = Integer.parseInt(myscanner.nextLine());
                    numA = numA - usernumberA;
                    break;
                case "B":
                case "b":
                    System.out.println("How many to remove from Pile B");
                    int usernumberB = Integer.parseInt(myscanner.nextLine());
                    numB = numB - usernumberB;
                    break;
                case "C":
                case "c":
                    System.out.println("How many to remove from Pile C");
                    int usernumberC = Integer.parseInt(myscanner.nextLine());
                    numC = numC - usernumberC;
                    break;
                default:
                    System.out.println("Please Enter a valid Input");
            }
            System.out.println("A: \t" + numA + "\t" + "B: \t" + numB + "\t" + "C: \t" + numC);
            if (numA == 0 && numB == 0 && numC == 0) {
                check = false;
            }
        }
             System.out.println("A: \t" + numA + "\t" + "B: \t" + numB + "\t" + "C: \t" + numC);
        System.out.println("All piles are empty. Good job!");
             }

         }