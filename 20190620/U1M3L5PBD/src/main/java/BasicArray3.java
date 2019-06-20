import java.util.ArrayList;
import java.util.Random;

public class BasicArray3 {
    public static void main(String[] args) {
        Random rand = new Random();
         int max= 99;
         int min = 10;

         ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int num = rand.nextInt((max - min) + 1) + min;
             list.add(num);
        }
        System.out.println("ArrayList: " + list);
    }
}