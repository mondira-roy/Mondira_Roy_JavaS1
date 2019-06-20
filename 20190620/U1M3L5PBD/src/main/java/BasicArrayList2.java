import java.util.*;

public class BasicArrayList2 {
    public static void main(String[] args) {
       Random rand = new Random();

   ArrayList<Integer> list =  new ArrayList<>();
       for(int i=0; i<10; i++) {
           int num = rand.nextInt(100);
           list.add(num);
       }
           System.out.println("ArrayList: " + list );
       }
    }
