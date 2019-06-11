import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {
        System.out.println("Please Enter your current earth weight:");
        Scanner myscan = new Scanner(System.in);
        double wt = Integer.parseInt(myscan.nextLine());
        System.out.println("I have information for the following planets:\n");
        System.out.println("1. Venus" + "2. Mars" + "3. Jupiter \n");
        System.out.println("4. Saturn" + "5.Uranus" + "Neptune \n");
        System.out.println("Which planet are you visiting?Pls enter the number");
        int userinput = myscan.nextInt();
        switch (userinput) {
            case 1:
                double w1 = 0.78 * wt;
                System.out.println("Your weight would be" + w1 + "pounds on that planet.");
                break;
            case 2:
                double w2 = 0.39 * wt;
                System.out.println("Your weight would be" + w2 + "pounds on that planet.");
                break;
            case 3:
                double w3 = 2.65 * wt;
                System.out.println("Your weight would be" + w3 + "pounds on that planet.");
                break;
            case 4:
                double w4 = 1.17 * wt;
                System.out.println("Your weight would be" + w4 + "pounds on that planet.");
                break;
            case 5:
                double w5 = 1.05 * wt;
                System.out.println("Your weight would be" + w5 + "pounds on that planet.");
                break;
            default:
                double weight = 1.23 * wt;
                System.out.println("Your weight would be" + weight + "pounds on that planet.");
        }
    }

}
