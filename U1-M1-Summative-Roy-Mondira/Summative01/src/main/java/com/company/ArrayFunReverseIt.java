package com.company;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.copyOf;

public class ArrayFunReverseIt {
    public static void main(String[] args) {

        int[] inputArr = {1,2,3,4,5};
        System.out.println("The First Array: \n" + Arrays.toString(inputArr));
       // int[] newArr = new int[5];
        int[] newArr= copyOf(inputArr , 5);
        System.out.println("Copy of First\n "+ Arrays.toString(newArr));

        for(int i = 0; i <newArr .length / 2; i++){
            int  temp = newArr[i]; // swap using temporary storage
            newArr[i] = newArr[5 - i - 1];
            newArr[5 - i - 1] = temp;
        }
        System.out.println("Reverse of First\n "+ Arrays.toString(newArr));

        }

    }


