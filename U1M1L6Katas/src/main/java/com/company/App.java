package com.company;

import java.io.Console;
import java.lang.*;
import java.util.*;


public class App {

    public static int total(int[] totalArr) {
        int sum = 0;
        for (int value : totalArr) {
            sum = sum + value;
        }
        return sum;
    }


    public static int totalOdd(int[] totalOddArr) {
        int odd = 0;
        for (int i = 1; i < totalOddArr.length; i = i + 2) {
            odd = odd + totalOddArr[i];
        }
        return odd;
    }


    public static int totalEven(int[] totalEvenArr) {
        int even = 0;
        for (int i = 0; i < totalEvenArr.length; i = i + 2) {
            even = even + totalEvenArr[i];
        }
        return even;
    }

    public static int secondLargestNumber(int arr[]) {
        //int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        int maxOne = arr[0];
        int maxTwo = arr[1];

        for (int i = 0; i < arr.length - 1; i++) {
            if (maxOne < arr[i + 1]) {
                maxTwo = maxOne;
                maxOne = arr[i + 1];
            } else if (maxTwo < arr[i + 1]) {
                maxTwo = arr[i + 1];
            }
        }
        return maxTwo;
    }

    public static String[] swapFirstAndLast(String[] fruits) {
        //String[] fruits = {"foo", "bar", "baz", "qux"};
        String first = fruits[0];
        String last = fruits[fruits.length - 1];
        fruits[0] = last;
        fruits[fruits.length - 1] = first;
        //String swapfruits= new String[fruits.length];
        return fruits;
    }

    public static String concatenateString(String[] str) {
        //str[] = {"apple","bananas","peaches","oranges"};
        //return a;
        String outstr = "";
        for (int i = 0; i < str.length; i++) {
            outstr = outstr + str[i];
        }
        return outstr;
    }

    public static int[] reverse(int[] revArr) {

        //int[] revArr = {0, 1, 2, 3, 4, 5, 6, 7};
        int end = revArr.length - 1;
        for (int start = 0; start < (revArr.length / 2); ++start) {
            int tmp = revArr[start];
            revArr[start] = revArr[end - start];
            revArr[end - start] = tmp;
        }
        return revArr;
    }

    public static int[] everyThird(int[] everyT) {

        if (everyT.length < 3) {
            return null;
        }
        int k = 0;
        int newlength = everyT.length / 3;
        int[] val = new int[newlength];
        for (int i = 2; i < everyT.length; i = i + 3, k++) {
            val[k] = everyT[i];

        }
        return val;
    }

    //===============================================================
    public static int[] lessThanFive(int[] inputarray) {
        //inputarray={2, 4, 7, 9, 11, 0, 3, 1, 5};
        int numberlessthanFive = 0;
        for (int i = 0; i < inputarray.length; i++) {
            if (inputarray[i] < 5) {
                numberlessthanFive = numberlessthanFive + 1;
            }
        }
        if (numberlessthanFive == 0) {
            return null; // returns null if no elements are 5 or greater
        }
        int j = 0;
        int[] lessFive = new int[numberlessthanFive];

        for (int i = 0; i < inputarray.length; i++) {
            if (inputarray[i] < 5) {
                lessFive[j] = inputarray[i];
                j++;
            }
            //System.out.println(i + "-" + ivalue + "-"+ lessFive[i]);
            //System.out.println(ivalue);
        }
        return lessFive;
    }

//========================================================

    public static int[][] splitAtFive(int[] inputArray) {
        int sizeOf2ndDim;
        int countGreater = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] >= 5) {
                countGreater = countGreater + 1;
                System.out.println("There are "+ countGreater + "numbers in Array greater that equal to 5");
            }
        }
        int[] arrayLess = new int[inputArray.length - countGreater];
        int[] arrayGreater = new int[countGreater];

        int j = 0, k = 0;
        sizeOf2ndDim = arrayLess.length;
        if (arrayGreater.length >= arrayLess.length) {
            sizeOf2ndDim = arrayGreater.length;
        }

        int[][] outTwoDimArray = new int[arrayLess.length][sizeOf2ndDim];

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < 5) {
                arrayLess[j] = inputArray[i];
                j = j + 1;
            } else {
                arrayGreater[k] = inputArray[i];
                k = k + 1;
            }
        }
        for ( j = 0; j < arrayLess.length; j++) {
            outTwoDimArray[0][j] = arrayLess[j];
            System.out.println("Array with numbers less than 5 "+ arrayLess[j]);
        }
        for (k = 0; k < arrayGreater.length; k++) {
            outTwoDimArray[1][k] = arrayGreater[k];
            System.out.println("Array with numbers greater than or equal to 5"+ arrayGreater[k]);
        }
        return outTwoDimArray;
    }
}
//=====================Odd and Even===================================



