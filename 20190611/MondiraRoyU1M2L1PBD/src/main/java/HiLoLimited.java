import java.util.Scanner;
import java.util.Random;

public class HiLoLimited {
    public static void main(String[] args) {

        Scanner myscanner = new Scanner(System.in);
        Random rand = new Random();
        int random = rand.nextInt(99) + 1;
        System.out.println("Welcome to Limited Hi-Low!");
        System.out.println("Please Enter your name:");
        String name = myscanner.nextLine();
        System.out.println("OK, " + name + ", here are the rules:");
        System.out.println("Guess a number between 1-100. You have 7 tries");
        int number = myscanner.nextInt();
//        System.out.println(random);
        boolean exactNumber = false;
        int guesses = 0;
        while (guesses< 7) ;

        {
            while (!exactNumber) ;
            {
                if (number < random) {
                    System.out.println("Too Low!");
                    System.out.println("Guess again!");
                    number = myscanner.nextInt();
                    guesses++;
                } else if (number > random) {
                    System.out.println("Too high!");
                    System.out.println("Guess again!");
                    number = myscanner.nextInt();
                    guesses++;
                } else {
                    System.out.println("Congratulations, " + name + "! You win!");
                    exactNumber = true;
                    guesses++;
                }
            }
            System.out.println("It took you " + guesses + " guesses to find my number!");
        }
        System.out.println("Too many tries");

    }

}