import java.util.Scanner;

public class Nim {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        boolean check = true;
        int numA = 3;
        int numB = 4;
        int numC = 5;
        String player1;
        String player2;
        boolean turn1 = true;

        System.out.println("Player 1, enter your name");
        player1 = myScanner.nextLine();
        System.out.println(player1);
        System.out.println();

        System.out.println("Player 2, enter your name");
        player2 = myScanner.nextLine();
        System.out.println(player2);

        while (check) {
            System.out.println("A: " + numA + " B: " + numB + " C: " + numC);
            if (turn1) {
                System.out.println(player1 + " choose a pile.");
            } else {
                System.out.println(player2 + " choose a pile.");
            }
           String pileInput = myScanner.nextLine();

            System.out.println("How many to remove from pile " + pileInput);
            int userInput = Integer.parseInt(myScanner.nextLine());

            // process inputs
            if (pileInput.equals("A") || pileInput.equals("a")) {
                numA = numA- userInput;

            } else if (pileInput.equals("B") || pileInput.equals("b")) {
                numB = numB - userInput;

            } else if (pileInput.equals("C") || pileInput.equals("c")) {
                numC = numC- userInput;
            }
            if (numA <= 0 && numB <= 0 && numC <= 0) {
                check = false;
            }
            if (turn1) {
                turn1 = false;
            } else {
                turn1 = true;
            }
        }
        System.out.println("A: " + numA + " B: " + numB + " C: " + numC);
        if (turn1) {
            System.out.println(player2 + ", There are no counters left, so you WIN!");
        } else {
            System.out.println(player1 + ", There are no counters left, so you WIN!");
        }
    }

}