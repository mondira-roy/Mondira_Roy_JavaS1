import java.util.Random;

public class BabyBlackJack {
    public static void main(String[] args) {
        Random rand1 = new Random();
        int user1 = rand1.nextInt(10);
        Random rand2 = new Random();
        int user2 = rand2.nextInt(10);
        Random rand3 = new Random();
        int dealer1 = rand3.nextInt(10);
        Random rand4 = new Random();
        int dealer2 = rand4.nextInt(10);
        int yournum = user1 + user2;
        int dealernum = dealer1 + dealer2;
        System.out.println(" Baby Black Jack!");
        System.out.println("You drew \t"+ user1 + "\t and \t" + user2);
        System.out.println("Your total is\t" + yournum);
        System.out.println( "The dealer has\t"+ dealer1 + " and \t" + dealer2);
        System.out.println("Dealer's total is\t" + dealernum);
        if (yournum > dealernum ){
            System.out.println("YOU WIN");
        }
    }

}



