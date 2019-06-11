import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Are you ready for a quiz?Y/N");
        String choice = myscanner.nextLine();
        //String value = "y";
        boolean b = Boolean.parseBoolean(choice);
        //System.out.println(b);
        if (b) {
            System.out.println("Okay, here it comes!\n");
            System.out.println("Q1) What is the capital of Alaska? \n");
            System.out.println("    1) Melbourne \n");
            System.out.println("    2) Anchorage \n");
            System.out.println("    3) Juneau");
            int answer1 = myscanner.nextInt();
            int score = 0;
            switch (answer1) {
                case 1:
                    System.out.println("Sorry, The correct answer is Juneau.");
                    break;
                case 2:
                    System.out.println("Sorry, The correct answer is Juneau.");
                    break;
                case 3:
                    System.out.println("That's right!");
                    score = score + 1;
                    break;
                default:
                    System.out.println("Next question?");

            }
            System.out.println("Q2) Can you store the value 'cat' in a variable of type int?");
            System.out.println("    1) Yes");
            System.out.println("    2) No");
            int answer2 = myscanner.nextInt();
            switch (answer2) {
                case 1:
                    System.out.println("Sorry, 'cat' is a string. Ints can only store numbers.");
                    break;
                case 2:
                    System.out.println("You are correct.");
                    score = score + 1;
                    break;
                default:
                    break;
            }
            System.out.println("Q3) Wht is the result of 9+6/3");
            System.out.println(" 1) 5");
            System.out.println(" 2) 11");
            System.out.println(" 3) 15/3");
            int answer3 = myscanner.nextInt();
            switch (answer3) {
                case 1:
                    System.out.println("It are incorrect");
                    break;
                case 2:
                    System.out.println("That's correct!");
                    score = score + 1;
                    break;
                default:
                    System.out.println("");
                    break;
            }
            System.out.println("Overall, you got" + score + "out of 3 correct");
            System.out.println("Thanks for playing!");
        }


    }
}

