import java.util.Random;
import java.util.Scanner;

public class NumberGuessCounter {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Random randomGenerator = new Random();
            int rollValue = randomGenerator.nextInt(10) + 1;
            int secret = rollValue; int counter=0;
            Scanner myscanner = new Scanner(System.in);
            System.out.println("I'm thinking of a number from 1 to 10.\n");
            System.out.println("Your Guess");
            int guess = Integer.parseInt(myscanner.nextLine());
            counter=counter+1;
            if (guess == rollValue) {
                System.out.println("That's right! You're a good guesser.");
                System.out.println("It only took you"+ counter + "tries.");
                break;
            } else {
                System.out.println("That is incorrect. Guess again.");
                //System.out.println("Keep Guessing");
            }
        }
    }
}



