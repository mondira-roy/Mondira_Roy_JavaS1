package com.company;

public class CalculatorRefactored {
    public static void main(String[] args) {
        int int1 = 1;
        int int2 = 3;

        long l1 = 4;
        long l2 = -3;

        float f1 = 1.5f;
        float f2 = 2.1f;

        double d1 = 0.7d;
        double d2 = 4.4d;
        CalculatorRefactored calc = new CalculatorRefactored.Add()
        System.out.println(add(int1, int2));
        System.out.println(add(d1, d2));
        System.out.println(add(l1, l2));
        System.out.println(add(f1, f2));

        System.out.println(subtract(int1, int2));
        System.out.println(subtract(d1, d2));
        System.out.println(subtract(l1, l2));
        System.out.println(subtract(f1, f2));


        System.out.println(multiply(int1, int2));
        System.out.println(multiply(d1, d2));
        System.out.println(multiply(l1, l2));
        System.out.println(multiply(f1, f2));

        System.out.println(divide(int1, int2));
        System.out.println(divide(d1, d2));
        System.out.println(divide(l1, l2));
        System.out.println(divide(f1, f2));

    }

    public class Add {

        public static int add(int num1, int num2) {
            return num1 + num2;
        }

        public static long add(long long1, long long2) {
            return long1 + long2;
        }

        public static float add(float float1, float float2) {
            return float1 + float2;
        }

        public static double add(double double1, double double2) {
            return double1 + double2;
        }
    }

    public class Subtract {
        public static int subtract(int num1, int num2) {
            return num1 - num2;
        }

        public static long subtract(long long1, long long2) {
            return long1 - long2;
        }

        public static double subtract(double double1, double double2) {
            return double1 - double2;
        }

        public static float subtract(float float1, float float2) {
            return float1 - float2;
        }
    }

    public class Multiply {
        public static long multiply(long long1, long long2) {
            return long1 * long2;
        }

        public static float multiply(float float1, float float2) {
            return float1 * float2;
        }

        public static double multiply(double double1, double double2) {
            return double1 * double2;
        }

        public static int multiply(int num1, int num2) {
            return num1 * num2;
        }
    }

    public class Divide {
        public static long divide(long long1, long long2) {
            return long1 / long2;
        }

        public static float divide(float float1, float float2) {
            return float1 / float2;
        }

        public static double divide(double double1, double double2) {
            return double1 / double2;
        }

        public static int divide(int num1, int num2) {
            return num1 / num2;
        }
    }
}

