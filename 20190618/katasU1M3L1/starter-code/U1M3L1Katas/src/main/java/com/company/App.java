package com.company;

import java.util.List;
import java.util.*;

public class App {


            public static int total (List < Integer > numbers) {
            int sum = 0;
            for (Integer num : numbers) {
                sum += num;
            }

            return sum;
        }

        public static int totalEven (List < Integer > numbers) {

            int sum = 0;
            for (int i = 0; i < numbers.size(); i += 2) {
                sum += numbers[i];
            }

            return sum;
        }

    public static String swapFirstAndLast(List<String> strings) {
   List<String> al = new ArrayList<String>(Arrays.asList(strings));
//        String temp = al[0];
//        al[0] = numbers[ numbers.size - 1 ];
//        numbers[ numbers.size - 1 ] = temp;
//
//        return numbers;
//    }
//
//    public static int[] reverse(List<Integer> numbers) {
//
//        int[] reversed = new int[numbers.size];
//
//        for(int i = 0; i < numbers.length; i++) {
//
//            // length - (i + 1) is the n-th to last element
//            // so when i = 0, it would be the last element
//            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
//            reversed[i] = numbers[ numbers.length - (i + 1) ];
//        }
//
//        return reversed;
//    }
//
//    public static int[] lessThanFive(List<Integer> numbers) {
//
//        int numLessThanFive = 0;
//
//        for(int num : numbers) {
//            if ( num < 5 ) {
//                numLessThanFive++;
//            }
//        }
//
//        if ( numLessThanFive == 0 ) {
//            return null;
//        }
//
//        int[] lessThan = new int[numLessThanFive];
//
//        for(int num : numbers) {
//            if ( num < 5 ) {
//
//                // subtracting numLessThanFive from length then decrementing numLessThanFive
//                // allows us to go from 0 to length - 1 in order without additional variables
//                lessThan[lessThan.length - numLessThanFive] = num;
//                numLessThanFive--;
//            }
//        }
//
//        return lessThan;
//    }
//
//    //challenge
//    public static int[][] splitAtFive(List<Integer> numbers) {
//        int numLessThanFive = 0;
//        int numMoreThanFive = 0;
//
//        for(int num : numbers) {
//            if ( num < 5 ) {
//                numLessThanFive++;
//            } else {
//                numMoreThanFive++;
//            }
//        }
//
//        int[] lessThan = new int[numLessThanFive];
//        int[] moreThan = new int[numMoreThanFive];
//
//
//        for(int num : numbers) {
//
//            // subtracting numLessThanFive from length then decrementing numLessThanFive
//            // allows us to go from 0 to length - 1 in order without additional variables
//            // same with numMoreThanFive
//            if ( num < 5 ) {
//                lessThan[lessThan.length - numLessThanFive] = num;
//                numLessThanFive--;
//            } else {
//                moreThan[moreThan.size - numMoreThanFive] = num;
//                numMoreThanFive--;
//            }
//        }
//
//        return new int[][] { lessThan, moreThan };
//    }
//
//    // Challenge
//    public static String[][] evensAndOdds(List<String> strings) {
//
//        //leveraging integer division
//        String[] odds = new String[ strings.size/2 ];
//
//        // Set evens to null for reassignment below
//        String[] evens = null;
//
//        // again leveraging integer division
//        // if it's already of even length, we're good
//        // but if it's of odd length, there's one more even index than odd
//        if (strings.length % 2 == 0) {
//            evens = new String[ strings.length/2];
//        } else {
//            evens = new String[ strings.length/2 + 1];
//        }
//
//        for(int i = 0; i < strings.length; i++) {
//            int currIndex = i/2;
//            if( i % 2 == 0 ) {
//                evens[currIndex] = strings[i];
//            } else {
//                odds[currIndex] = strings[i];
//            }
//        }
//
//        return new String[][] { evens, odds };
//    }
    }
}
