import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {

        Random randomGenerator = new Random();
        int rollValue = randomGenerator.nextInt(6) + 1;
        int secret = rollValue;
        int rollValue1 = randomGenerator.nextInt(6) + 1;
        int secret1 = rollValue1;
        int thenum = secret1 + secret;
        //Scanner myscanner = new Scanner(System.in);
        System.out.println("Here comes the Dice Roll.\n");
        System.out.println("Roll #1" + rollValue);
        System.out.println("Roll #2" + rollValue1);
        System.out.println("The total is" + thenum);
    }

    }