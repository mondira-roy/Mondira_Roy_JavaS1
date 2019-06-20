import java.util.ArrayList;

public class BasicArrayList1 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list.add(i);
            System.out.println("Slot " +i +"Contains a "+ list.get(i) );
        }
    }
}
