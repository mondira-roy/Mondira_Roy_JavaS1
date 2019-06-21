import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LocatingLargest {
    public static void main(String[] args) {

        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100) + 1;
            list.add(num);
        }
        System.out.println(list);

        int max = 0;
        for (Integer i1 : list) {
            // update max if found to be less than
            // the current element
            if (max < i1) {
                max = i1;
            }

        }
        System.out.println("The Largest value is " + max +","+ " which " +
                "is in Slot " + list.indexOf(max) );

    }

}
