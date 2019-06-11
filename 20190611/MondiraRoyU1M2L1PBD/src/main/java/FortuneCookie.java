import java.util.Random;
import java.util.Scanner;

public class FortuneCookie {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) ;
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(6);
        System.out.println(randomInt);
        System.out.println("Fortune cookie says: \"You will find happiness with a new love.\n");

    }
}