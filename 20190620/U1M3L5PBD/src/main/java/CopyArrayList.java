import java.util.ArrayList;
import java.util.Random;

public class CopyArrayList {
    public static void main(String[] args) {
        Random rand = new Random();

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            list1.add(num);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addAll(list1);
        list1.set(9, -7);
        System.out.println("ArrayList1: " + list1);
        System.out.println("ArrayList2: " + list2);
    }
}
