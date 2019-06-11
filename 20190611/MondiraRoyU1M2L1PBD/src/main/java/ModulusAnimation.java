public class ModulusAnimation {
    public static void main(String[] args) throws Exception {
        int repeats = 5;
        int steps_per_second = 10;
        for (int i = 0; i < 80; i++) {
            if (i % 13 == 0) {
                System.out.print(" +*+..... \r");
            } else if (i % 13 == 1) {
                System.out.print(" ..+*+.... \r");
            } else if (i % 13 == 2) {
                System.out.print(" ...+*+... \r");
            } else if (i % 13 == 3) {
                System.out.print(" ....+*+.... \r");
            } else if (i % 13 == 4) {
                System.out.print(" .....+*+. \r");
            } else if (i % 13 == 5) {
                System.out.print(" ......+*+ \r");
            } else if (i % 13 == 6) {
                System.out.print(" .......+* \r");
            } else if (i % 13 == 7) {
                System.out.print(" +.......+ \r");
            } else if (i % 13 == 8) {
                System.out.print(" +*....... \r");
            } else if (i % 13 == 9) {
                System.out.print(" +*+...... \r");
            } else if (i % 10 == 10) {
                System.out.print(" .+*+..... \r");
                System.out.print(" Mr. Mitchell is cool. \r");
            }
            Thread.sleep(200);
        }
    }
}