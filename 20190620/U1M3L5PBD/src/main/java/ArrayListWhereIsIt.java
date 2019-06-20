import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayListWhereIsIt {
    public static void main(String[] args) {

        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(50);
            list.add(num);
        }
        //Get user Input
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Value to find: ");
        int userNum = Integer.parseInt(myscanner.nextLine());

        if (list.contains(userNum)) {
            System.out.println("ArrayList: " + list);
            System.out.println(userNum + " is in the ArrayList");
            System.out.println(userNum + " is in slot " + list.indexOf(userNum));
        } else {
            System.out.println(userNum + " is not in the ArrayList");
        }
    }
}
