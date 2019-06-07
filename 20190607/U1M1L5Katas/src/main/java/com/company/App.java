package com.company;


public class App {
    public static void main(String[] args) {
//        int sub= subtract(7,4);
//        int sub0=subtractOrZero(2,17);
//        int max1 = max(5,6,7);
//        int mini = min(5,6,7);

    }

    public static int subtract(int a, int b) {
        int diff = a - b;
        return diff;
    }

    public static int subtractOrZero(int a, int b) {
        int diff = a - b;
        int ret = 0;
        if (diff < 0) {
            return ret;
        } else {
            return diff;
        }
    }


    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > c) {
            return b;
        } else {
            return c;
        }
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < c) {
            return b;
        } else {
            return c;
        }
    }

    public static Boolean isLarger(int first, int second) {
        return first>second;

    }
}


